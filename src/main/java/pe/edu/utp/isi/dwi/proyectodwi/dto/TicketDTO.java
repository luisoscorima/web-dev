package pe.edu.utp.isi.dwi.proyectodwi.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class TicketDTO {
    private int id_solicitud;
    private String asunto;
    private String prioridad;
    private Date fechaCreacion;
    private String estado;

    // Getters y setters
    public int getId() { return id_solicitud; }
    public void setId(int id) { this.id_solicitud = id; }

    public String getAsunto() { return asunto; }
    public void setAsunto(String asunto) { this.asunto = asunto; }

    public String getPrioridad() { return prioridad; }
    public void setPrioridad(String prioridad) { this.prioridad = prioridad; }

    public Date getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(Date fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
