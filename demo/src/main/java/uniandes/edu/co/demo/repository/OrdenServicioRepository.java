package uniandes.edu.co.demo.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import uniandes.edu.co.demo.modelo.OrdenServicio;
import uniandes.edu.co.demo.modelo.Servicio;

public interface OrdenServicioRepository extends MongoRepository<OrdenServicio, Integer> {

    @Query(value = "{}", fields = "{ 'servicio': 0 }")
    List<OrdenServicio> findAllOrdenes();

    @Query("{_id: ?0}")
    List<OrdenServicio> findOrdenById(int id);

    default void insertOrden(OrdenServicio orden) {
        save(orden);
    }

    @Query("{_id: ?0}")
    @Update("{ $set: { fecha: ?1, afiliado_objetivo: ?2, medico_rescriptor: ?3, estado_orden: ?4, servicio: ?5 } }")
    void updateOrden(int id, Date fecha, int afiliado_objetivo, int medico_rescriptor, String estado_orden, Servicio servicio);

    @Query(value = "{_id: ?0}", delete = true)
    void deleteOrdenById(int id);
}