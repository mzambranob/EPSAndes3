package uniandes.edu.co.demo.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection = "afiliados")
@ToString
public class Afiliado {
    @Id
    private int numero_documento;

    private String tipo_documento;
    private String nombre;
    private String fecha_nacimiento;
    private String direccion_residencia;
    private String telefono;
    private String estado;
    private String tipo;
    private String parentezco;

    private List<IPS> ipss;

    // Constructor
    public Afiliado(int numero_documento, String tipo_documento, String nombre, String fecha_nacimiento,
            String direccion_residencia, String telefono, String estado, String tipo, String parentezco,
            List<IPS> ipss) {
        this.numero_documento = numero_documento;
        this.tipo_documento = tipo_documento;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion_residencia = direccion_residencia;
        this.telefono = telefono;
        this.estado = estado;
        this.tipo = tipo;
        this.parentezco = parentezco;
        this.ipss = ipss;

        // Getters y Setters
    }

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

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDireccion_residencia() {
        return direccion_residencia;
    }

    public void setDireccion_residencia(String direccion_residencia) {
        this.direccion_residencia = direccion_residencia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
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

    public String getParentezco() {
        return parentezco;
    }

    public void setParentezco(String parentezco) {
        this.parentezco = parentezco;
    }

    public List<IPS> getIpss() {
        return ipss;
    }

    public void setIpss(List<IPS> ipss) {
        this.ipss = ipss;
    }
}
