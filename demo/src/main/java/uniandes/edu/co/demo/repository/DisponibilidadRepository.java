package uniandes.edu.co.demo.repository;

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
    @Update("{ $set: { estado_disponibilidad: ?1, fecha_disponibilidad: ?2, servicio: ?3, codigo_nit: ?4, numero_medico_asociado: ?5, id_orden_asociada: ?6, cc_afiliado_asociado: ?7 } }")
    void updateDisponibilidad(int id, String estado_disponibilidad, String fecha_disponibilidad, Servicio servicio,
            int codigo_nit, int numero_medico_asociado, Integer id_orden_asociada, Integer cc_afiliado_asociado);

    @Query(value = "{_id: ?0}", delete = true)
    void deleteDisponibilidadById(int id);

    //RF7-1
   @Query("{ 'servicio.id_servicio': ?0, 'fecha_disponibilidad': { $gte: ?1 }, 'estado_disponibilidad': 'DISPONIBLE' }")
    List<Disponibilidad> findDisponibilidadFuturaByServicio(int idServicio, String fechaDesde);

    //RF7-2
    @Query("{_id: ?0}")
    @Update("{ $set: { estado_disponibilidad: 'OCUPADA', cc_afiliado_asociado: ?1, id_orden_asociada: ?2 } }")
    void agendarDisponibilidad(int idDisponibilidad, int afiliadoCC, int idOrden);

}
