package uniandes.edu.co.demo.modelo;

public enum EstadoEnum {

    DISPONIBLE("DISPONIBLE"),
    PENDIENTE("PENDIENTE"),
    CANCELADA("CANCELADA"),
    PROCESADA("PROCESADA");

    public String estado_disponibilidad;

    private EstadoEnum(String estado_disponibilidad) {
        this.estado_disponibilidad = estado_disponibilidad;
    }
}
