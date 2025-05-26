package uniandes.edu.co.demo.repository;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RFC1Repository {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public RFC1Repository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Document> getAgendaDisponibilidadPorServicio(int id_servicio) {
        // Obtener la fecha actual y la fecha dentro de 4 semanas
        Date fechaInicio = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaInicio);
        calendar.add(Calendar.DAY_OF_YEAR, 28);
        Date fechaFin = calendar.getTime();

        List<Document> pipeline = List.of(
            new Document("$match", new Document()
                .append("servicio.id_servicio", id_servicio)
                .append("estado_disponibilidad", "DISPONIBLE")
                .append("fecha_disponibilidad", new Document()
                    .append("$gte", fechaInicio)
                    .append("$lte", fechaFin)
                )
            ),
            new Document("$lookup", new Document()
                .append("from", "medicos")
                .append("localField", "numero_medico_asociado")
                .append("foreignField", "numero_registro_medico")
                .append("as", "medico")
            ),
            new Document("$unwind", "$medico"),
            new Document("$lookup", new Document()
                .append("from", "ipss")
                .append("localField", "codigo_nit")
                .append("foreignField", "codigo_nit")
                .append("as", "ips")
            ),
            new Document("$unwind", "$ips"),
            new Document("$project", new Document()
                .append("_id", 0)
                .append("nombre_servicio", "$servicio.tipo_servicio")
                .append("fecha_disponibilidad", 1)
                .append("nombre_medico", "$medico.nombre")
                .append("nombre_ips", "$ips.nombre")
            )
        );

        return mongoTemplate.getCollection("disponibilidad")
            .aggregate(pipeline)
            .into(new ArrayList<>());
    }
}
