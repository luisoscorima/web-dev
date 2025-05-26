
package pe.edu.utp.isi.dwi.proyectodwi.dao;

import pe.edu.utp.isi.dwi.proyectodwi.model.Solicitud;
import java.sql.*;

public class SolicitudDAO {

    private Connection conn;

    public SolicitudDAO(Connection conn) {
        this.conn = conn;
    }

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

    // NUEVO MÉTODO para registrar ticket y devolver el ID generado
    public int registrarSolicitudYRetornarId(Solicitud s, int idCliente) throws SQLException {
        String sql = "INSERT INTO solicitud (asunto, motivo, prioridad, id_tipoSolicitud, id_cliente, id_aplicacion) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, s.getAsunto());
            ps.setString(2, s.getMotivo());
            ps.setString(3, s.getPrioridad());
            ps.setInt(4, s.getIdTipoSolicitud());
            ps.setInt(5, idCliente);
            if (s.getIdAplicacion() != 0) {
                ps.setInt(6, s.getIdAplicacion());
            } else {
                ps.setNull(6, java.sql.Types.INTEGER);
            }

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // ID del ticket recién generado
            } else {
                throw new SQLException("No se pudo obtener el ID generado para la solicitud.");
            }
        }
    }
}
