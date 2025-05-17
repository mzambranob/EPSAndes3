package uniandes.edu.co.demo.modelo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection = "ordenesServicio")
@ToString
public class OrdenServicio {

    @Id
    private int id_orden;

    private Date fecha;
    private int afiliado_objetivo;
    private int medico_rescriptor;
    private EstadoEnum estado_orden;

    private Servicio servicio;

    // Constructor
    public OrdenServicio(int id_orden, Date fecha, int afiliado_objetivo, int medico_rescriptor,
            EstadoEnum estado_orden, Servicio servicio) {
        this.id_orden = id_orden;
        this.fecha = fecha;
        this.afiliado_objetivo = afiliado_objetivo;
        this.medico_rescriptor = medico_rescriptor;
        this.estado_orden = estado_orden;
        this.servicio = servicio;
    }

    // Getters y Setters
    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getAfiliado_objetivo() {
        return afiliado_objetivo;
    }

    public void setAfiliado_objetivo(int afiliado_objetivo) {
        this.afiliado_objetivo = afiliado_objetivo;
    }

    public int getMedico_rescriptor() {
        return medico_rescriptor;
    }

    public void setMedico_rescriptor(int medico_rescriptor) {
        this.medico_rescriptor = medico_rescriptor;
    }

    public EstadoEnum getEstado_orden() {
        return estado_orden;
    }

    public void setEstado_orden(EstadoEnum estado_orden) {
        this.estado_orden = estado_orden;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
