package uniandes.edu.co.demo.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import uniandes.edu.co.demo.modelo.Servicio;
import uniandes.edu.co.demo.modelo.IPS;
import uniandes.edu.co.demo.modelo.Medico;

public interface ServicioRepository extends MongoRepository<Servicio, Integer> {

    @Query(value = "{}", fields = "{ 'ipss': 0, 'medicos': 0 }")
    List<Servicio> findAllServicios();

    @Query("{_id: ?0}")
    List<Servicio> findServicioById(int id);

    default void insertServicio(Servicio servicio) {
        save(servicio);
    }

    @Query("{_id: ?0}")
    @Update("{ $set: { tipo_servicio: ?1, necesita_orden: ?2, horario_servicio: ?3, ipss: ?4, medicos: ?5 } }")
    void updateServicio(int id, String tipo_servicio, int necesita_orden, String horario_servicio,
            List<Integer> ipss, List<Integer> medicos);

    @Query(value = "{_id: ?0}", delete = true)
    void deleteServicioById(int id);
}
