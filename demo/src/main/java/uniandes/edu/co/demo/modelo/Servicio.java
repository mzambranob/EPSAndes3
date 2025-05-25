package uniandes.edu.co.demo.modelo;

import java.util.Date;
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
    private Date horario_servicio;

    private List<IPS> ipss;
    private List<Medico> medicos;

    // Constructor
    public Servicio(int id_servicio, ServicioEnum tipo_servicio, int necesita_orden, Date horario_servicio,
            List<IPS> ipss, List<Medico> medicos) {
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

    public Date getHorario_servicio() {
        return horario_servicio;
    }

    public void setHorario_servicio(Date horario_servicio) {
        this.horario_servicio = horario_servicio;
    }

    public List<IPS> getIpss() {
        return ipss;
    }

    public void setIpss(List<IPS> ipss) {
        this.ipss = ipss;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }
}
