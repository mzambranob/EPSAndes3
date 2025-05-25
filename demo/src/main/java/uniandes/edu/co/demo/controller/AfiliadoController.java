package uniandes.edu.co.demo.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.demo.modelo.Afiliado;
import uniandes.edu.co.demo.repository.AfiliadoRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/afiliados")
public class AfiliadoController {

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    @PostMapping("/new/save")
    public ResponseEntity<String> createAfiliado(@RequestBody Afiliado afiliado) {

        try {
            afiliadoRepository.save(afiliado);
            return new ResponseEntity<>("Afiliado creado con éxito", HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el afiliado: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{id}/edit/save")
    public ResponseEntity<String> updateAfiliado(@PathVariable("id") int id, @RequestBody Afiliado afiliado) {
        try {
            afiliadoRepository.updateAfiliado(id, afiliado.getTipo_documento(), afiliado.getNombre(),
                    afiliado.getFecha_nacimiento(), afiliado.getDireccion_residencia(), afiliado.getTelefono(),
                    afiliado.getEstado(), afiliado.getTipo(), afiliado.getParentezco());

            return new ResponseEntity<>("Afiliado actualizado con éxito", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el afiliado: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("")
    public ResponseEntity<List<Afiliado>> getAllAfiliados() {
        try {
            List<Afiliado> afiliados = afiliadoRepository.findAllAfiliados();
            return ResponseEntity.ok(afiliados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Afiliado>> getAfiliadoById(@PathVariable("id") int id) {
        try {
            List<Afiliado> afiliados = afiliadoRepository.findAfiliadoById(id);
            if (afiliados != null && !afiliados.isEmpty()) {
                return ResponseEntity.ok(afiliados);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteAfiliado(@PathVariable("id") int id) {
        try {
            afiliadoRepository.deleteAfiliadoPorId(id);
            return new ResponseEntity<>("Afiliado eliminado con éxito", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el afiliado: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
