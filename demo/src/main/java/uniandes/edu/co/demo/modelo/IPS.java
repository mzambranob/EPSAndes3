package uniandes.edu.co.demo.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection = "ipss")
@ToString
public class IPS {

    @Id
    private int _id;

    private int codigo_nit;
    private String nombre;
    private String direccion;
    private int telefono;

    private String horario_atencion;

    private List<Medico> medicos;
    private List<Integer> afiliados;
    private List<Integer> servicios;

    // Constructor
    public IPS(int codigo_nit, String nombre, String direccion, int telefono, String horario_atencion,
            List<Medico> medicos, List<Integer> afiliados, List<Integer> servicios) {
        this._id = codigo_nit;
        this.codigo_nit = codigo_nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horario_atencion = horario_atencion;
        this.medicos = medicos;
        this.afiliados = afiliados;
        this.servicios = servicios;

    }

    // Getters y Setters

    public int getCodigo_nit() {
        return codigo_nit;
    }

    public void setCodigo_nit(int codigo_nit) {
        this.codigo_nit = codigo_nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getHorario_atencion() {
        return horario_atencion;
    }

    public void setHorario_atencion(String horario_atencion) {
        this.horario_atencion = horario_atencion;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    public List<Integer> getAfiliados() {
        return afiliados;
    }

    public void setAfiliados(List<Integer> afiliados) {
        this.afiliados = afiliados;
    }

    public List<Integer> getServicios() {
        return servicios;
    }

    public void setServicios(List<Integer> servicios) {
        this.servicios = servicios;
    }
}
