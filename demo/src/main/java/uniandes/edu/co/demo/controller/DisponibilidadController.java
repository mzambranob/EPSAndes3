package uniandes.edu.co.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.demo.modelo.Disponibilidad;
import uniandes.edu.co.demo.repository.DisponibilidadRepository;

@RestController
@RequestMapping("/disponibilidades")
public class DisponibilidadController {

    @Autowired
    private DisponibilidadRepository disponibilidadRepository;

    @PostMapping("/new/save")
    public ResponseEntity<String> createDisponibilidad(@RequestBody Disponibilidad d) {
        try {
            disponibilidadRepository.save(d);
            return new ResponseEntity<>("Disponibilidad creada con éxito", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la disponibilidad: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{id}/edit/save")
    public ResponseEntity<String> updateDisponibilidad(@PathVariable("id") int id, @RequestBody Disponibilidad d) {
        try {
            disponibilidadRepository.updateDisponibilidad(
                id,
                d.getEstado_disponibilidad().toString(),
                d.getFecha_disponibilidad(),
                d.getServicio(),
                d.getCodigo_nit(),
                d.getNumero_medico_asociado(),
                d.getId_orden_asociada(),
                d.getCc_afiliado_objetivo()
            );
            return new ResponseEntity<>("Disponibilidad actualizada con éxito", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la disponibilidad: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Disponibilidad>> getAllDisponibilidades() {
        try {
            return ResponseEntity.ok(disponibilidadRepository.findAllDisponibilidades());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Disponibilidad>> getDisponibilidadById(@PathVariable("id") int id) {
        try {
            List<Disponibilidad> disponibilidades = disponibilidadRepository.findDisponibilidadById(id);
            return disponibilidades != null && !disponibilidades.isEmpty() ? ResponseEntity.ok(disponibilidades) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteDisponibilidad(@PathVariable("id") int id) {
        try {
            disponibilidadRepository.deleteDisponibilidadById(id);
            return new ResponseEntity<>("Disponibilidad eliminada con éxito", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la disponibilidad: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

