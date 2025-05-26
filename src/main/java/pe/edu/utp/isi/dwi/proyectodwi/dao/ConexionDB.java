package pe.edu.utp.isi.dwi.proyectodwi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static ConexionDB instancia;
    private Connection connection;

    private ConexionDB() throws SQLException {
        String url = "jdbc:postgresql://my-db-instance.cytmkkegmp14.us-east-1.rds.amazonaws.com:5432/postgres"; // Reemplaza 'midatabase'
        String usuario = "userutp";
        String contrasena = "VU4B5np-8EyU";

        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, usuario, contrasena);
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontró el driver de PostgreSQL", e);
        }
    }

    public static synchronized ConexionDB getInstance() throws SQLException {
        if (instancia == null) {
            instancia = new ConexionDB();
        }
        return instancia;
    }

    public Connection getConnection() {
        return connection;
    }
}
