package pe.edu.utp.isi.dwi.proyectodwi.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class filters implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Inicialización del filtro
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String uri = httpRequest.getRequestURI();
        
        if (uri.endsWith(".jsp") && !uri.contains("/jsp/")) {
            // Construye la nueva ruta con /jsp/
            String contextPath = httpRequest.getContextPath();
            String newUri = contextPath + "/jsp" + uri.substring(uri.lastIndexOf('/'));
            
            ((HttpServletResponse) response).sendRedirect(newUri);
            return;
        }
        
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Limpieza del filtro
    }
}