package uniandes.edu.co.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.IPS;
import uniandes.edu.co.demo.modelo.Medico;

public interface IPSRepository extends MongoRepository<IPS, Integer> {

    @Query(value = "{}", fields = "{ 'medicos' : 0, 'afiliados' : 0, 'servicios' : 0 }")
    List<IPS> findAllIPSs();

    @Query("{_id: ?0}")
    List<IPS> findIPSById(int id);

    default void insertIPS(IPS ips) {
        save(ips);
    }

    @Query("{_id: ?0}")
    @Update("{ $set: { nombre: ?1, direccion: ?2, telefono: ?3, horario_atencion: ?4, medicos: ?5, afiliados: ?6, servicios: ?7 } }")
    void updateIPS(int id, String nombre, String direccion, int telefono, String horario_atencion,
            List<Medico> medicos, List<Integer> afiliados, List<Integer> servicios);

    @Query(value = "{_id: ?0}", delete = true)
    void deleteIPSPorId(int id);

}
