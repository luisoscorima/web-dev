
package pe.edu.utp.isi.dwi.proyectodwi.controller;

import pe.edu.utp.isi.dwi.proyectodwi.dao.SolicitudDAO;
import pe.edu.utp.isi.dwi.proyectodwi.dao.ColaboradorDAO;
import pe.edu.utp.isi.dwi.proyectodwi.model.Solicitud;
import pe.edu.utp.isi.dwi.proyectodwi.model.Colaborador;
import pe.edu.utp.isi.dwi.proyectodwi.controller.ConexionDB;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/AdministradorDashboardServlet")
public class AdministradorDashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Connection conn = ConexionDB.getInstance().getConnection();
            SolicitudDAO solicitudDAO = new SolicitudDAO(conn);
            ColaboradorDAO colaboradorDAO = new ColaboradorDAO(conn);

            int totalTickets = solicitudDAO.contarTotalTickets();
            int totalAsignados = solicitudDAO.contarTicketsAsignados();
            List<Solicitud> ultimosTickets = solicitudDAO.listarUltimosTickets(5);
            Solicitud ticketReciente = solicitudDAO.obtenerTicketMasReciente();
            List<Colaborador> colaboradores = colaboradorDAO.listarColaboradores();

            request.setAttribute("totalTickets", totalTickets);
            request.setAttribute("totalAsignados", totalAsignados);
            request.setAttribute("ultimosTickets", ultimosTickets);
            request.setAttribute("ticketReciente", ticketReciente);
            request.setAttribute("colaboradores", colaboradores);

            request.getRequestDispatcher("administrador-vista.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error en dashboard admin");
        }
    }
}
