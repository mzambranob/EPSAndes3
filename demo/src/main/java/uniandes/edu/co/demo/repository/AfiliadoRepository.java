package uniandes.edu.co.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.Afiliado;
import uniandes.edu.co.demo.modelo.IPS;

public interface AfiliadoRepository extends MongoRepository<Afiliado, Integer> {

    @Query(value = "{}", fields = "{'codigos_nit_ips': 0}")
    List<Afiliado> findAllAfiliados();

    @Query("{_id: ?0}")
    List<Afiliado> findAfiliadoById(int id);

    default void insertAfiliado(Afiliado afiliado) {
        save(afiliado);
    }

    @Query("{_id: ?0}")
    @Update("{ $set: { tipo_documento: ?1, nombre: ?2, fecha_nacimiento: ?3, direccion_residencia: ?4, telefono: ?5, estado: ?6, tipo: ?7, parentezco: ?8 } }")
    void updateAfiliado(int id, String tipo_documento, String nombre, Date fecha_nacimiento,
            String direccion_residencia, int telefono, String estado, String tipo, Integer parentezco,
            List<Integer> codigos_nit_ipss);

    @Query(value = "{_id: ?0}", delete = true)
    void deleteAfiliadoPorId(int id);

    @Query(value = "{_id: ?0}", fields = "{'ipss': 1}")
    List<IPS> findIPSsByAfiliado(int id);

}
