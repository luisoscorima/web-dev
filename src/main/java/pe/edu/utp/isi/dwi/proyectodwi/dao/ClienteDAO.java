
package pe.edu.utp.isi.dwi.proyectodwi.dao;

import pe.edu.utp.isi.dwi.proyectodwi.model.Cliente;

import java.sql.*;

public class ClienteDAO {
    private Connection conn;

    public ClienteDAO(Connection conn) {
        this.conn = conn;
    }

    public Cliente obtenerClientePorId(int idCliente) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCliente);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Cliente c = new Cliente();
                    c.setIdCliente(rs.getInt("id_cliente"));
                    c.setNombre(rs.getString("nombre_cliente"));
                    c.setApellido(rs.getString("apellido_cliente"));
                    c.setEmail(rs.getString("email_cliente"));
                    c.setTipoCliente(rs.getString("tipo_cliente"));
                    c.setEstado(rs.getString("estado_cliente"));
                    c.setIdEmpresa(rs.getInt("id_empresa"));
                    return c;
                }
            }
        }
        return null;
    }
}
