package uniandes.edu.co.demo.repository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RFC1Repository {

    private final MongoTemplate mongoTemplate;

    public RFC1Repository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Document> consultarDisponibilidadServicio(int idServicio) {

        LocalDate hoy = LocalDate.now();
        Date fechaInicio = Date.from(hoy.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date fechaFin = Date.from(hoy.plusWeeks(4).atStartOfDay(ZoneId.systemDefault()).toInstant());

        List<Document> pipeline = List.of(
                new Document("$match", new Document()
                        .append("servicio.id_servicio", idServicio)
                        .append("estado_disponibilidad", "DISPONIBLE")
                        .append("fecha_disponibilidad", new Document("$gte", fechaInicio).append("$lte", fechaFin))),
                new Document("$lookup", new Document()
                        .append("from", "medicos")
                        .append("localField", "numero_medico_asociado")
                        .append("foreignField", "numero_registro_medico")
                        .append("as", "medico")),
                new Document("$unwind", "$medico"),

                new Document("$lookup", new Document()
                        .append("from", "ipss")
                        .append("localField", "codigo_nit")
                        .append("foreignField", "codigo_nit")
                        .append("as", "ips")),
                new Document("$unwind", "$ips"),

                new Document("$project", new Document()
                        .append("_id", 0)
                        .append("nombre_servicio", "$servicio.tipo_servicio")
                        .append("fecha_disponibilidad", 1)
                        .append("nombre_medico", "$medico.nombre")
                        .append("nombre_ips", "$ips.nombre")));

        return mongoTemplate.getCollection("disponibilidad")
                .aggregate(pipeline)
                .into(new ArrayList<>());
    }
}
