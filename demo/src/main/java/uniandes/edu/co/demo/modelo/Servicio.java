package uniandes.edu.co.demo.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection = "servicios")
@ToString
public class Servicio {

    @Id
    private int _id;
    private int id_servicio;

    private ServicioEnum tipo_servicio;
    private int necesita_orden;
    private String horario_servicio;

    private List<Integer> ipss;
    private List<Integer> medicos;

    // Constructor
    public Servicio(int id_servicio, ServicioEnum tipo_servicio, int necesita_orden, String horario_servicio,
            List<Integer> ipss, List<Integer> medicos) {

        this._id = id_servicio;
        this.id_servicio = id_servicio;
        this.tipo_servicio = tipo_servicio;
        this.necesita_orden = necesita_orden;
        this.horario_servicio = horario_servicio;
        this.ipss = ipss;
        this.medicos = medicos;
    }

    // Getters y Setters

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public ServicioEnum getTipo_servicio() {
        return tipo_servicio;
    }

    public void setTipo_servicio(ServicioEnum tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    public int getNecesita_orden() {
        return necesita_orden;
    }

    public void setNecesita_orden(int necesita_orden) {
        this.necesita_orden = necesita_orden;
    }

    public String getHorario_servicio() {
        return horario_servicio;
    }

    public void setHorario_servicio(String horario_servicio) {
        this.horario_servicio = horario_servicio;
    }

    public List<Integer> getIpss() {
        return ipss;
    }

    public void setIpss(List<Integer> ipss) {
        this.ipss = ipss;
    }

    public List<Integer> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Integer> medicos) {
        this.medicos = medicos;
    }
}
