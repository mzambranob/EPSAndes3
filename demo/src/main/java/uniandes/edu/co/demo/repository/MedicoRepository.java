package uniandes.edu.co.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.Medico;

public interface MedicoRepository extends MongoRepository<Medico, Integer> {

        @Query(value = "{}", fields = "{'codigos_nit_ips': 0, 'ordenes_servicios': 0}")
        List<Medico> findAllMedicos();

        @Query("{_id: ?0}")
        List<Medico> findMedicoById(int id);

        default void insertMedico(Medico medico) {
                save(medico);
        }

        @Query("{_id: ?0}")
        @Update("{ $set: { nombre: ?1, especialidad: ?2, tipo_documento: ?3, codigos_nit_ips: ?4, ordenes_servicios: ?5 } }")
        void updateMedico(int id, String nombre,
                        String especialidad, String tipo_documento, List<Integer> codigos_nit_ips,
                        List<Integer> ordenes_servicios);

        @Query(value = "{_id: ?0}", delete = true)
        void deleteMedicoPorId(int id);

        @Query(value = "{_id: ?0}", fields = "{'codigos_nit_ips': 1}")
        List<Integer> findIPSsByMedico(int id);

        @Query(value = "{_id: ?0}", fields = "{'ordenes_servicios': 1}")
        List<Integer> findOrdenesServiciosByMedico(int id);

}
