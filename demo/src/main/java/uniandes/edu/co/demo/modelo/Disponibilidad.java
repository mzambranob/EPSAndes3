package uniandes.edu.co.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection = "disponibilidad")
@ToString
public class Disponibilidad {

    @Id
    private int _id;

    private int id_disponibilidad;
    private EstadoEnum estado_disponibilidad;

    private String fecha_disponibilidad;

    private Servicio servicio;
    private int codigo_nit;
    private int numero_medico_asociado;
    private int id_orden_asociada;
    private int cc_afiliado_asociado;

    // Constructor
    public Disponibilidad(int id_disponibilidad, EstadoEnum estado_disponibilidad, String fecha_disponibilidad,
            Servicio servicio, int codigo_nit, int numero_medico_asociado, int id_orden_asociada,
            int cc_afiliado_asociado) {

        this._id = id_disponibilidad;
        this.id_disponibilidad = id_disponibilidad;
        this.estado_disponibilidad = estado_disponibilidad;
        this.fecha_disponibilidad = fecha_disponibilidad;
        this.servicio = servicio;
        this.codigo_nit = codigo_nit;
        this.numero_medico_asociado = numero_medico_asociado;
        this.id_orden_asociada = id_orden_asociada;
        this.cc_afiliado_asociado = cc_afiliado_asociado;

    }

    // Getters y Setters

    public int getId_disponibilidad() {
        return id_disponibilidad;
    }

    public void setId_disponibilidad(int id_disponibilidad) {
        this.id_disponibilidad = id_disponibilidad;
    }

    public EstadoEnum getEstado_disponibilidad() {
        return estado_disponibilidad;
    }

    public void setEstado_disponibilidad(EstadoEnum estado_disponibilidad) {
        this.estado_disponibilidad = estado_disponibilidad;
    }

    public String getFecha_disponibilidad() {
        return fecha_disponibilidad;
    }

    public void setFecha_disponibilidad(String fecha_disponibilidad) {
        this.fecha_disponibilidad = fecha_disponibilidad;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public int getCodigo_nit() {
        return codigo_nit;
    }

    public void setCodigo_nit(int codigo_nit) {
        this.codigo_nit = codigo_nit;
    }

    public int getNumero_medico_asociado() {
        return numero_medico_asociado;
    }

    public void setNumero_medico_asociado(int numero_medico_asociado) {
        this.numero_medico_asociado = numero_medico_asociado;
    }

    public int getId_orden_asociada() {
        return id_orden_asociada;
    }

    public void setId_orden_asociada(int id_orden_asociada) {
        this.id_orden_asociada = id_orden_asociada;
    }

    public int getCc_afiliado_asociado() {
        return cc_afiliado_asociado;
    }

    public void setCc_afiliado_asociado(int cc_afiliado_asociado) {
        this.cc_afiliado_asociado = cc_afiliado_asociado;
    }
}
