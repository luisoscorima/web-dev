
package pe.edu.utp.isi.dwi.proyectodwi.model;

public class Solicitud {
    private String asunto;
    private String motivo;
    private String prioridad;
    private int idTipoSolicitud;
    private int idAplicacion;

    public String getAsunto() { return asunto; }
    public void setAsunto(String asunto) { this.asunto = asunto; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public String getPrioridad() { return prioridad; }
    public void setPrioridad(String prioridad) { this.prioridad = prioridad; }

    public int getIdTipoSolicitud() { return idTipoSolicitud; }
    public void setIdTipoSolicitud(int idTipoSolicitud) { this.idTipoSolicitud = idTipoSolicitud; }

    public int getIdAplicacion() { return idAplicacion; }
    public void setIdAplicacion(int idAplicacion) { this.idAplicacion = idAplicacion; }
}
