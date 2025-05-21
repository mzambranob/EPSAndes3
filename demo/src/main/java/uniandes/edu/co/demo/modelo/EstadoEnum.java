package uniandes.edu.co.demo.modelo;

public enum EstadoEnum {

    DISPONIBLE("DISPONIBLE"),
    VIGENTE("VIGENTE"),
    PENDIENTE("PENDIENTE"),
    CANCELADA("CANCELADA"),
    COMPLETADA("COMPLETADA"),
    PROCESADA("PROCESADA");

    public String estado_disponibilidad;

    private EstadoEnum(String estado_disponibilidad) {
        this.estado_disponibilidad = estado_disponibilidad;
    }
}
