
package pe.edu.utp.isi.dwi.proyectodwi.dao;

import pe.edu.utp.isi.dwi.proyectodwi.model.Solicitud;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import pe.edu.utp.isi.dwi.proyectodwi.dto.TicketDTO;
import pe.edu.utp.isi.dwi.proyectodwi.dto.TicketDetailDTO;

public class SolicitudDAO {

    private Connection conn;

    public SolicitudDAO(Connection conn) {
        this.conn = conn;
    }

    public List<TicketDTO> listarTicketsPorColaborador(int colaboradorId) throws SQLException {
        String sql = "SELECT s.id_solicitud, s.asunto, s.estado, s.prioridad, s.fecha_creacion, a.es_coordinador " +
                 "FROM solicitud s " +
                 "JOIN asignacion a ON s.id_solicitud = a.id_solicitud " +
                 "WHERE a.id_colaborador = ? " +
                 "ORDER BY s.fecha_creacion DESC";
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
        String sql = "SELECT " +
                 "s.id_solicitud, s.asunto, s.motivo, s.prioridad, s.estado, s.fecha_creacion, " +
                 "c.nombre_cliente, c.apellido_cliente, " +
                 "colab.nombre_colab, colab.apellido_colab, " +
                 "ts.descripcion AS tipo_solicitud, " +
                 "app.tipo_aplicacion " +
                 "FROM solicitud s " +
                 "JOIN cliente c ON s.id_cliente = c.id_cliente " +
                 "LEFT JOIN asignacion a ON s.id_solicitud = a.id_solicitud " +
                 "LEFT JOIN colaborador colab ON a.id_colaborador = colab.id_colaborador " +
                 "JOIN tiposolicitud ts ON s.id_tiposolicitud = ts.id_tiposolicitud " +
                 "LEFT JOIN aplicacion app ON s.id_aplicacion = app.id_aplicacion " +
                 "WHERE s.id_solicitud = ?";
        try (PreparedStatement p = conn.prepareStatement(sql)) {
            p.setInt(1, solicitudId);
            ResultSet r = p.executeQuery();
            if (!r.next()) return null;
            TicketDetailDTO d = new TicketDetailDTO();
                    d.setIdSolicitud(r.getInt("id_solicitud"));
                    d.setAsunto(r.getString("asunto"));
                    d.setMotivo(r.getString("motivo"));
                    d.setPrioridad(r.getString("prioridad"));
                    d.setEstado(r.getString("estado"));
                    d.setFechaCreacion(r.getTimestamp("fecha_creacion").toLocalDateTime());
                    d.setNombreCliente(r.getString("nombre_cliente") + " " + r.getString("apellido_cliente"));
                    d.setNombreColaborador(r.getString("nombre_colab") + " " + r.getString("apellido_colab"));
                    d.setTipoSolicitud(r.getString("tipo_solicitud"));
                    d.setAplicativo(r.getString("tipo_aplicacion"));
            return d;
        }
    }

    // MÉTODO para registrar ticket y devolver el ID generado
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
