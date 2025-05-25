package uniandes.edu.co.demo.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection = "medicos")
@ToString
public class Medico {

    @Id
    private int _id;

    private int numero_registro_medico;
    private int numero_documento;
    private String nombre;
    private String especialidad;
    private String tipo_documento;

    private List<Integer> codigos_nit_ips;
    private List<Integer> ordenes_servicios;

    // Constructor
    public Medico(int numero_registro_medico, int numero_documento, String nombre, String especialidad,
            String tipo_documento, List<Integer> codigos_nit_ips,
            List<Integer> ordenes_servicios) {
        this._id = numero_registro_medico;
        this.numero_registro_medico = numero_registro_medico;
        this.numero_documento = numero_documento;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.tipo_documento = tipo_documento;
        this.codigos_nit_ips = codigos_nit_ips;
        this.ordenes_servicios = ordenes_servicios;
    }

    // Getters y Setters

    public int getNumero_registro_medico() {
        return numero_registro_medico;
    }

    public void setNumero_registro_medico(int numero_registro_medico) {
        this.numero_registro_medico = numero_registro_medico;
    }

    public int getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(int numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public List<Integer> getCodigos_nit_ips() {
        return codigos_nit_ips;
    }

    public void setCodigos_nit_ips(List<Integer> codigos_nit_ips) {
        this.codigos_nit_ips = codigos_nit_ips;
    }

    public List<Integer> getOrdenes_servicios() {
        return ordenes_servicios;
    }

    public void setOrdenes_servicios(List<Integer> ordenes_servicios) {
        this.ordenes_servicios = ordenes_servicios;
    }
}
