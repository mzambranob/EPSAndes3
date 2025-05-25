package uniandes.edu.co.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.demo.modelo.Medico;
import uniandes.edu.co.demo.repository.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    

    @PostMapping("/{id}/edit/save")
    public ResponseEntity<String> updateMedico(@PathVariable("id") int id, @RequestBody Medico medico) {
        try {
            medicoRepository.updateMedico(
                    id,
                    medico.getNombre(),
                    medico.getEspecialidad(),
                    medico.getTipo_documento(),
                    medico.getCodigos_nit_ips(),
                    medico.getOrdenes_servicios());

            return new ResponseEntity<>("Medico actualizado con éxito", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el médico: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Medico>> getAllMedicos() {
        try {
            List<Medico> medicos = medicoRepository.findAllMedicos();
            return ResponseEntity.ok(medicos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Medico>> getMedicoById(@PathVariable("id") int id) {
        try {
            List<Medico> medicos = medicoRepository.findMedicoById(id);
            if (medicos != null && !medicos.isEmpty()) {
                return ResponseEntity.ok(medicos);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteMedico(@PathVariable("id") int id) {
        try {
            medicoRepository.deleteMedicoPorId(id);
            return new ResponseEntity<>("Medico eliminado con éxito", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el médico: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    //RF4
    @PostMapping("/new/save")
    public ResponseEntity<String> createMedico(@RequestBody Medico medico) {
        try {
            medicoRepository.save(medico);
            return new ResponseEntity<>("Medico creado con éxito", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el médico: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
