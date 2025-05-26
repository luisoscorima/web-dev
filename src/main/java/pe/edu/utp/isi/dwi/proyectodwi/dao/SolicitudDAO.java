package pe.edu.utp.isi.dwi.proyectodwi.dao;

public class SolicitudDAO {
    // inyección de DataSource, Connection, etc.

    public List<TicketDTO> listarTicketsPorColaborador(int colaboradorId) throws SQLException {
        String sql = /* tu consulta #2 */;
        try (PreparedStatement p = conn.prepareStatement(sql)) {
            p.setInt(1, colaboradorId);
            ResultSet r = p.executeQuery();
            List<TicketDTO> lista = new ArrayList<>();
            while (r.next()) {
                TicketDTO t = new TicketDTO();
                t.setIdSolicitud(r.getInt("id_solicitud"));
                t.setAsunto(r.getString("asunto"));
                t.setEstado(r.getString("estado"));
                t.setPrioridad(r.getString("prioridad"));
                t.setFechaCreacion(r.getTimestamp("fecha_creacion").toLocalDateTime());
                t.setEsCoordinador(r.getBoolean("es_coordinador"));
                lista.add(t);
            }
            return lista;
        }
    }

    public TicketDetailDTO obtenerDetalleTicket(int solicitudId) throws SQLException {
        String sql = /* tu consulta #3 */;
        try (PreparedStatement p = conn.prepareStatement(sql)) {
            p.setInt(1, solicitudId);
            ResultSet r = p.executeQuery();
            if (!r.next()) return null;
            TicketDetailDTO d = new TicketDetailDTO();
            // mapear campos escalares...
            // para asignaciones y actividades, parsear los JSON o hacer consultas separadas
            return d;
        }
    }
}
