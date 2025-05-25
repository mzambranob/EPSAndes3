package uniandes.edu.co.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.demo.modelo.OrdenServicio;
import uniandes.edu.co.demo.repository.OrdenServicioRepository;

@RestController
@RequestMapping("/ordenes")
public class OrdenServicioController {

    @Autowired
    private OrdenServicioRepository ordenServicioRepository;

    @PostMapping("/new/save")
    public ResponseEntity<String> createOrden(@RequestBody OrdenServicio orden) {
        try {
            ordenServicioRepository.save(orden);
            return new ResponseEntity<>("Orden de servicio creada con éxito", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la orden: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{id}/edit/save")
    public ResponseEntity<String> updateOrden(@PathVariable("id") int id, @RequestBody OrdenServicio orden) {
        try {
            ordenServicioRepository.updateOrden(
                id,
                orden.getFecha(),
                orden.getAfiliado_objetivo(),
                orden.getMedico_rescriptor(),
                orden.getEstado_orden().toString(),
                orden.getServicio()
            );
            return new ResponseEntity<>("Orden de servicio actualizada con éxito", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la orden: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<OrdenServicio>> getAllOrdenes() {
        try {
            return ResponseEntity.ok(ordenServicioRepository.findAllOrdenes());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<OrdenServicio>> getOrdenById(@PathVariable("id") int id) {
        try {
            List<OrdenServicio> ordenes = ordenServicioRepository.findOrdenById(id);
            return ordenes != null && !ordenes.isEmpty() ? ResponseEntity.ok(ordenes) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteOrden(@PathVariable("id") int id) {
        try {
            ordenServicioRepository.deleteOrdenById(id);
            return new ResponseEntity<>("Orden de servicio eliminada con éxito", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la orden: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
