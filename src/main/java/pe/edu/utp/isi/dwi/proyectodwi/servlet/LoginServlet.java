package pe.edu.utp.isi.dwi.proyectodwi.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pe.edu.utp.isi.dwi.proyectodwi.dao.UserDAO;
import pe.edu.utp.isi.dwi.proyectodwi.model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        try {
            User user = userDAO.validateUser(email, password);
            
            if (user != null) {
                // Credenciales válidas - crear sesión
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                session.setAttribute("user_id", user.getId());
                
                // Redirigir a página de inicio
                response.sendRedirect("home.jsp");
            } else {
                // Credenciales inválidas
                request.setAttribute("errorMessage", "Email o contraseña incorrectos");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error en el sistema. Por favor intente más tarde.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
           
        }
    }
}