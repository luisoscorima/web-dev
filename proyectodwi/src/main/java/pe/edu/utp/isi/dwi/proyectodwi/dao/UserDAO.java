package pe.edu.utp.isi.dwi.proyectodwi.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import pe.edu.utp.isi.dwi.proyectodwi.model.User;

public class UserDAO {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/tudatabase";
    private static final String DB_USER = "tuusuario";
    private static final String DB_PASSWORD = "tucontraseña";
    
    // Método para validar usuario
    public User validateUser(String email, String password) throws SQLException {
        String sql = "SELECT id, email, name, registration_date FROM usuarios WHERE email = ? AND password = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, email);
            stmt.setString(2, password);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setEmail(rs.getString("email"));
                    user.setName(rs.getString("name"));
                    user.setRegistrationDate(rs.getDate("registration_date"));
                    return user;
                }
            }
        }
        return null;
    }
    
    // Método para registrar nuevo usuario
    public boolean registerUser(User user) throws SQLException {
        String sql = "INSERT INTO usuarios (email, password, name) VALUES (?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getName());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }
    
    // Otros métodos CRUD pueden ir aquí...
}