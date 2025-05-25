package uniandes.edu.co.demo.modelo;

public enum ServicioEnum {

    CONSULTA_MEDICOGENERAL("CONSULTA_MEDICOGENERAL"),
    CONSULTA_ESPECIALISTA("CONSULTA_ESPECIALISTA"),
    CONSULTA_CONTROL("CONSULTA_CONTROL"),
    EXAMEN_DIAGNOSTICO("EXAMEN_DIAGNOSTICO"),
    CONSULTA_URGENCIAS("CONSULTA_URGENCIAS"),
    TERAPIA("TERAPIA"),
    PROCEDIMIENTO_ESPECIALIZADO("PROCEDIMIENTO_ESPECIALIZADO"),
    HOSPITALIZACION("HOSPITALIZACION");

    public String tipo_servicio;

    private ServicioEnum(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }
}
