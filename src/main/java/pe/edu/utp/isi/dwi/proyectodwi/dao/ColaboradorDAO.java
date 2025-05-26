
package pe.edu.utp.isi.dwi.proyectodwi.dao;

import pe.edu.utp.isi.dwi.proyectodwi.model.Colaborador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ColaboradorDAO {
    private Connection conn;

    public ColaboradorDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Colaborador> listarColaboradores() throws SQLException {
        String sql = "SELECT * FROM colaborador WHERE estado_colab = true";
        List<Colaborador> lista = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Colaborador c = new Colaborador();
                c.setId(rs.getInt("id_colaborador"));
                c.setNombre(rs.getString("nombre_colab"));
                c.setApellido(rs.getString("apellido_colab"));
                c.setEmail(rs.getString("email_colab"));
                lista.add(c);
            }
        }
        return lista;
    }
}
