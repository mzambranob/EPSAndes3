package uniandes.edu.co.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.demo.modelo.Servicio;
import uniandes.edu.co.demo.repository.ServicioRepository;

@RestController
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private ServicioRepository servicioRepository;

    @PostMapping("/new/save")
    public ResponseEntity<String> createServicio(@RequestBody Servicio servicio) {
        try {
            servicioRepository.save(servicio);
            return new ResponseEntity<>("Servicio creado con éxito", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el servicio: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{id}/edit/save")
    public ResponseEntity<String> updateServicio(@PathVariable("id") int id, @RequestBody Servicio servicio) {
        try {
            servicioRepository.updateServicio(id, servicio.getTipo_servicio().toString(), servicio.getNecesita_orden(),
                    servicio.getHorario_servicio(), servicio.getIpss(), servicio.getMedicos());
            return new ResponseEntity<>("Servicio actualizado con éxito", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el servicio: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Servicio>> getAllServicios() {
        try {
            return ResponseEntity.ok(servicioRepository.findAllServicios());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Servicio>> getServicioById(@PathVariable("id") int id) {
        try {
            List<Servicio> servicios = servicioRepository.findServicioById(id);
            return servicios != null && !servicios.isEmpty() ? ResponseEntity.ok(servicios) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteServicio(@PathVariable("id") int id) {
        try {
            servicioRepository.deleteServicioById(id);
            return new ResponseEntity<>("Servicio eliminado con éxito", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el servicio: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
