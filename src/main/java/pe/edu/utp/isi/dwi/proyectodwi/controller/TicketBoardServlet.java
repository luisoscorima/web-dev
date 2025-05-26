package pe.edu.utp.isi.dwi.proyectodwi.controller;

import pe.edu.utp.isi.dwi.proyectodwi.dao.SolicitudDAO;
import pe.edu.utp.isi.dwi.proyectodwi.dto.TicketDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/tickets")
public class TicketBoardServlet extends HttpServlet {
    private SolicitudDAO dao = new SolicitudDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int colaboradorId = Integer.parseInt(req.getSession().getAttribute("userId").toString());
        try {
            List<TicketDTO> tickets = dao.listarTicketsPorColaborador(colaboradorId);
            req.setAttribute("tickets", tickets);
            req.getRequestDispatcher("/WEB-INF/views/tickets.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
