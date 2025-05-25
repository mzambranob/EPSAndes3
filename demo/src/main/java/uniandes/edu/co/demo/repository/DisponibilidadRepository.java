package uniandes.edu.co.demo.repository;

import java.sql.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import uniandes.edu.co.demo.modelo.Disponibilidad;
import uniandes.edu.co.demo.modelo.Servicio;

public interface DisponibilidadRepository extends MongoRepository<Disponibilidad, Integer> {

    @Query(value = "{}", fields = "{ 'servicio': 0 }")
    List<Disponibilidad> findAllDisponibilidades();

    @Query("{_id: ?0}")
    List<Disponibilidad> findDisponibilidadById(int id);

    default void insertDisponibilidad(Disponibilidad d) {
        save(d);
    }

    @Query("{_id: ?0}")
    @Update("{ $set: { estado_disponibilidad: ?1, fecha_disponibilidad: ?2, servicio: ?3, codigo_nit: ?4, numero_medico_asociado: ?5, id_orden_asociada: ?6, cc_afiliado_objetivo: ?7 } }")
    void updateDisponibilidad(int id, String estado_disponibilidad, Date fecha_disponibilidad, Servicio servicio,
                               int codigo_nit, int numero_medico_asociado, int id_orden_asociada, int cc_afiliado_objetivo);

    @Query(value = "{_id: ?0}", delete = true)
    void deleteDisponibilidadById(int id);
}
