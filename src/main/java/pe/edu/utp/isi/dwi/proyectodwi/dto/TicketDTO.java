package pe.edu.utp.isi.dwi.proyectodwi.dto;

import java.time.LocalDateTime;

public class TicketDTO {
    private int idSolicitud;
    private String asunto;
    private String estado;
    private String prioridad;
    private LocalDateTime fechaCreacion;
    private boolean esCoordinador;

    // getters y setters
}
