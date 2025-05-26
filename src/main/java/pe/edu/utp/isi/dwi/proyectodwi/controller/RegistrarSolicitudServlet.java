/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package pe.edu.utp.isi.dwi.proyectodwi.servlet;

import pe.edu.utp.isi.dwi.proyectodwi.controller.ConexionDB;
import pe.edu.utp.isi.dwi.proyectodwi.dao.SolicitudDAO;
import pe.edu.utp.isi.dwi.proyectodwi.model.Solicitud;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/RegistrarSolicitudServlet")
public class RegistrarSolicitudServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String asunto = request.getParameter("asunto");
        String motivo = request.getParameter("motivo");
        String prioridad = request.getParameter("prioridad");
        String tipoSolicitud = request.getParameter("tipoSolicitud");
        String idAplicacion = request.getParameter("idAplicacion");

        Solicitud s = new Solicitud();
        s.setAsunto(asunto);
        s.setMotivo(motivo);
        s.setPrioridad(prioridad);
        s.setIdTipoSolicitud(Integer.parseInt(tipoSolicitud));
        s.setIdAplicacion(idAplicacion != null && !idAplicacion.isEmpty() ? Integer.parseInt(idAplicacion) : 0);

        // Simulación del ID del cliente (reemplaza por lógica real cuando se tenga)
        int idCliente = 1;

        try {
            Connection conn = ConexionDB.getInstance().getConnection();
            SolicitudDAO dao = new SolicitudDAO(conn);
            int idTicket = dao.registrarSolicitudYRetornarId(s, idCliente);

            response.sendRedirect("crear-ticket.jsp?ticketId=" + idTicket);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "No se pudo registrar la solicitud.");
            request.getRequestDispatcher("crear-ticket.jsp").forward(request, response);
        }
    }
}
