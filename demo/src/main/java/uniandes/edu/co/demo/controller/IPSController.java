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

import uniandes.edu.co.demo.modelo.IPS;
import uniandes.edu.co.demo.repository.IPSRepository;

@RestController
@RequestMapping("/IPSs")
public class IPSController {

    @Autowired
    private IPSRepository ipsRepository;

    @PostMapping("/new/save")
    public ResponseEntity<String> createIPS(@RequestBody IPS ips) {
        try {
            ipsRepository.save(ips);
            return new ResponseEntity<>("IPS creado con exito", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la IPS: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{id}/edit/save")
    public ResponseEntity<String> updateIPS(@PathVariable("id") int id, @RequestBody IPS ips) {
        try {
            ipsRepository.updateIPS(
                    id,
                    ips.getNombre(),
                    ips.getDireccion(),
                    ips.getTelefono(),
                    ips.getHorario_atencion(),
                    ips.getMedicos(),
                    ips.getAfiliados(),
                    ips.getServicios());

            return new ResponseEntity<>("IPS actualizado con exito", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la IPS: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<IPS>> getAllIPSs() {
        try {
            List<IPS> ipss = ipsRepository.findAllIPSs();
            return ResponseEntity.ok(ipss);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<IPS>> getIPSById(@PathVariable("id") int id) {
        try {
            List<IPS> ipss = ipsRepository.findIPSById(id);
            if (ipss != null && !ipss.isEmpty()) {
                return ResponseEntity.ok(ipss);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteIPS(@PathVariable("id") int id) {
        try {
            ipsRepository.deleteIPSPorId(id);
            return new ResponseEntity<>("IPS eliminado con exito", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la IPS: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
