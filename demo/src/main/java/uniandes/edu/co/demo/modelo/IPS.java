package uniandes.edu.co.demo.modelo;

import java.util.Date;
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
    private String telefono;
    private Date horario_atencion;

    private List<Medico> medicos;
    private List<Afiliado> afiliados;
    private List<Servicio> servicios;

    // Constructor
    public IPS(int _id, int codigo_nit, String nombre, String direccion, String telefono, Date horario_atencion,
            List<Medico> medicos, List<Afiliado> afiliados, List<Servicio> servicios) {
        this._id = _id;
        this.codigo_nit = codigo_nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horario_atencion = horario_atencion;
        this.medicos = medicos;
        this.afiliados = afiliados;
        this.servicios = servicios;

        // Getters y Setters
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getHorario_atencion() {
        return horario_atencion;
    }

    public void setHorario_atencion(Date horario_atencion) {
        this.horario_atencion = horario_atencion;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    public List<Afiliado> getAfiliados() {
        return afiliados;
    }

    public void setAfiliados(List<Afiliado> afiliados) {
        this.afiliados = afiliados;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }
}
