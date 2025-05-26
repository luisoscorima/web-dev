package pe.edu.utp.isi.dwi.proyectodwi.controller;

import pe.edu.utp.isi.dwi.proyectodwi.dao.SolicitudDAO;
import pe.edu.utp.isi.dwi.proyectodwi.dto.TicketDetailDTO;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/ticketDetails")
public class TicketDetailsServlet extends HttpServlet {
    private SolicitudDAO dao = new SolicitudDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int solicitudId = Integer.parseInt(req.getParameter("id"));
        try {
            TicketDetailDTO detalle = dao.obtenerDetalleTicket(solicitudId);
            req.setAttribute("detalle", detalle);
            req.getRequestDispatcher("/WEB-INF/views/ticketDetails.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
