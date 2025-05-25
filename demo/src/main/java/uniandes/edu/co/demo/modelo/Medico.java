package uniandes.edu.co.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection = "medicos")
@ToString
public class Medico {

    @Id
    private int _id;

    private int numero_registroMedico;
    private int numero_documento;
    private String nombre;
    private String especialidad;
    private String tipo_documento;

    // Constructor
    public Medico(int numero_registroMedico, int numero_documento, String nombre, String especialidad,
            String tipo_documento) {
        this._id = numero_registroMedico;
        this.numero_registroMedico = numero_registroMedico;
        this.numero_documento = numero_documento;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.tipo_documento = tipo_documento;
    }

    // Getters y Setters

    public int getNumero_registroMedico() {
        return numero_registroMedico;
    }

    public void setNumero_registroMedico(int numero_registroMedico) {
        this.numero_registroMedico = numero_registroMedico;
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
}
