package uniandes.edu.co.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RFC2Repository {

    private final MongoTemplate mongoTemplate;

    public RFC2Repository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Document> get20mostSolicitedServicios() {
        List<Document> pipeline = List.of(
                new Document("$group", new Document("_id",
                        new Document("id_servicio", "$servicio.id_servicio")
                                .append("tipo_servicio", "$servicio.tipo_servicio"))
                        .append("totalSolicitudes", new Document("$sum", 1))),
                new Document("$sort", new Document("totalSolicitudes", -1)),
                new Document("$limit", 20),
                new Document("$project", new Document("_id", 0)
                        .append("id_servicio", "$_id.id_servicio")
                        .append("tipo_servicio", "$_id.tipo_servicio")
                        .append("totalSolicitudes", 1)));

        return mongoTemplate.getCollection("disponibilidad")
                .aggregate(pipeline)
                .into(new ArrayList<>());
    }

}
