package uniandes.edu.co.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.Afiliado;
import uniandes.edu.co.demo.modelo.IPS;

public interface AfiliadoRepository extends MongoRepository<Afiliado, Integer> {

    @Query(value = "{}", fields = "{'ipss': 0}")
    List<Afiliado> findAllAfiliados();

    @Query("{_id: ?0}")
    Afiliado findAfiliadoById(int id);

    default void insertAfiliado(Afiliado afiliado) {
        save(afiliado);
    }

    @Query("{_id: ?0}")
    @Update("{ $set: { nombre: ?1, apellido: ?2, edad: ?3, direccion: ?4, telefono: ?5, estado: ?6, tipo: ?7, parentezco: ?8 } }")
    void updateAfiliado(String nombre, String apellido, int edad, String direccion, String telefono,
            String estado, String tipo, String parentezco);

    @Query(value = "{_id: ?0}", delete = true)
    void deleteAfiliadoPorId(int id);

    @Query(value = "{_id: ?0}", fields = "{'ipss': 1}")
    List<IPS> findIPSsPerAfiliado(int id);

}
