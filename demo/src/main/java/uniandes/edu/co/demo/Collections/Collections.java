package uniandes.edu.co.demo.Collections;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.demo.modelo.Disponibilidad;
import uniandes.edu.co.demo.modelo.OrdenServicio;

public class Collections {
    //Los que van en Repository
    //RF4
    @Query("{ 'afiliado_objetivo': ?0, 'fecha': { $gte: ?1, $lte: ?2 } }")
    List<OrdenServicio> findServiciosByAfiliadoAndFecha(int afiliadoId, Date desde, Date hasta);
    //RF5
    @Query("{ 'servicio.tipo_servicio': ?0, 'medico_prescriptor': ?1, 'fecha': { $gte: ?2, $lte: ?3 } }")
    List<OrdenServicio> findOrdenesByTipoMedicoFechas(String tipoServicio, int medicoId, Date desde, Date hasta);

    //RF6
    @Query("{ 'servicio.tipo_servicio': ?0, 'medico_prescriptor': ?1, 'fecha': { $gte: ?2, $lte: ?3 } }")
    List<OrdenServicio> findOrdenesByTipoMedicoFechas(String tipoServicio, int medicoId, Date desde, Date hasta);

    //RF7-1
    @Query("{ 'servicio.id_servicio': ?0, 'fecha_disponibilidad': { $gte: ?1 }, 'estado_disponibilidad': 'DISPONIBLE' }")
    List<Disponibilidad> findDisponibilidadFuturaByServicio(int idServicio, String fechaDesde);
    //RF7-2
    @Query("{_id: ?0}")
    @Update("{ $set: { estado_disponibilidad: 'OCUPADA', cc_afiliado_asociado: ?1, id_orden_asociada: ?2 } }")
    void agendarDisponibilidad(int idDisponibilidad, int afiliadoCC, int idOrden);

    //Los que van en Controller
    //RF4
@GetMapping("/rf4")
public ResponseEntity<List<OrdenServicio>> rf4(
        @RequestParam int afiliadoId,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date desde,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date hasta) {
    try {
        return ResponseEntity.ok(ordenServicioRepository.findServiciosByAfiliadoAndFecha(afiliadoId, desde, hasta));
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

// RF5
@GetMapping("/rf5")
public ResponseEntity<List<OrdenServicio>> rf5(
        @RequestParam String tipoServicio,
        @RequestParam int medicoId,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date desde,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date hasta) {
    try {
        return ResponseEntity.ok(ordenServicioRepository.findOrdenesByTipoMedicoFechas(tipoServicio, medicoId, desde, hasta));
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

// RF6
@GetMapping("/rf6")
public ResponseEntity<List<OrdenServicio>> rf6(
        @RequestParam String tipoServicio,
        @RequestParam int medicoId,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date desde,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date hasta) {
    try {
        return ResponseEntity.ok(ordenServicioRepository.findOrdenesByTipoMedicoFechas(tipoServicio, medicoId, desde, hasta));
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}


//RF7.1
@GetMapping("/rf7.1")
public ResponseEntity<List<Disponibilidad>> rf7_1(@RequestParam int idServicio, @RequestParam String fechaDesde) {
    try {
        return ResponseEntity.ok(disponibilidadRepository.findDisponibilidadFuturaByServicio(idServicio, fechaDesde));
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

//RF7.2
@PostMapping("/rf7.2")
public ResponseEntity<String> rf7_2(
        @RequestParam int idDisponibilidad,
        @RequestParam int ccAfiliado,
        @RequestParam int idOrden) {
    try {
        disponibilidadRepository.agendarDisponibilidad(idDisponibilidad, ccAfiliado, idOrden);
        return new ResponseEntity<>("Disponibilidad agendada con éxito", HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>("Error al agendar la disponibilidad: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

}
