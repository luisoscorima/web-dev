package pe.edu.utp.isi.dwi.proyectodwi.dto;

import java.time.LocalDateTime;
import java.util.List;
//import pe.edu.utp.isi.dwi.proyectodwi.dto.ActividadDTO;
//import pe.edu.utp.isi.dwi.proyectodwi.dto.AsignacionDTO;

public class TicketDetailDTO {
    private int idSolicitud;
    private String asunto;
    private String motivo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaCierre;
    private String estado;
    private String prioridad;
    private String tipoSolicitud;
    private String descripcionTipo;
    private String nombreCliente;
    private String apellidoCliente;
    private String emailCliente;
    private String empresa;
    private String tipoAplicacion;
//    private List<AsignacionDTO> asignaciones;
//    private List<ActividadDTO> actividades;
    // getters y setters
}
