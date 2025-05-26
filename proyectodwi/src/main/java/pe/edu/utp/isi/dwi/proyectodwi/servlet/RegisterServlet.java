package pe.edu.utp.isi.dwi.proyectodwi.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pe.edu.utp.isi.dwi.proyectodwi.dao.UserDAO;
import pe.edu.utp.isi.dwi.proyectodwi.model.User;



@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        
        // Validaciones básicas
        if (!password.equals(confirmPassword)) {
            request.setAttribute("errorMessage", "Las contraseñas no coinciden");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }
        
        User newUser = new User(email, password, name);
        
        try {
            boolean isRegistered = userDAO.registerUser(newUser);
            
            if (isRegistered) {
                request.setAttribute("successMessage", "Registro exitoso. Por favor inicie sesión.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Error al registrar el usuario. El email ya puede estar en uso.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error en el sistema. Por favor intente más tarde.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}