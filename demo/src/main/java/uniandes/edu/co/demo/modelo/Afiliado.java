package uniandes.edu.co.demo.modelo;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.ToString;

@Document(collection = "afiliados")
@ToString
public class Afiliado {
    @Id
    private int _id;

    private int numero_documento;
    private String tipo_documento;
    private String nombre;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date fecha_nacimiento;

    private String direccion_residencia;
    private int telefono;
    private String estado;
    private String tipo;
    private Integer parentezco;

    private List<Integer> codigos_nit_ips;

    // Constructor
    public Afiliado(int numero_documento, String tipo_documento, String nombre, Date fecha_nacimiento,
            String direccion_residencia, int telefono, String estado, String tipo, Integer parentezco,
            List<Integer> codigos_nit_ips) {
        this._id = numero_documento;
        this.numero_documento = numero_documento;
        this.tipo_documento = tipo_documento;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion_residencia = direccion_residencia;
        this.telefono = telefono;
        this.estado = estado;
        this.tipo = tipo;
        this.parentezco = parentezco;
        this.codigos_nit_ips = codigos_nit_ips;
    }

    // Getters y Setters

    public int getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(int numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDireccion_residencia() {
        return direccion_residencia;
    }

    public void setDireccion_residencia(String direccion_residencia) {
        this.direccion_residencia = direccion_residencia;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getParentezco() {
        return parentezco;
    }

    public void setParentezco(Integer parentezco) {
        this.parentezco = parentezco;
    }

    public List<Integer> getCodigos_nit_Ips() {
        return codigos_nit_ips;
    }

    public void setCodigos_nit_Ips(List<Integer> codigos_nit_ipss) {
        this.codigos_nit_ips = codigos_nit_ipss;
    }
}
