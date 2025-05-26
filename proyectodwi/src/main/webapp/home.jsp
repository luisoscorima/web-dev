<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="pe.edu.utp.isi.dwi.proyectodwi.model.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Inicio - 123 Digital</title>
    <link rel="stylesheet" type="text/css" href="css/home-styles.css">
</head>
<body>
    <div class="welcome-container">
        <div class="user-info">
            <h1>Bienvenido, ${user.name}!</h1>
            <p>Email: ${user.email}</p>
            <p>Miembro desde: ${user.registrationDate}</p>
        </div>
        
        <div class="dashboard-options">
            <div class="option-card">
                <h3>Soporte Técnico</h3>
                <p>Gestiona tus solicitudes de soporte técnico</p>
            </div>
            
            <div class="option-card">
                <h3>Desarrollo</h3>
                <p>Solicita nuevos desarrollos o mejoras</p>
            </div>
            
            <div class="option-card">
                <h3>Capacitación</h3>
                <p>Accede a nuestros cursos de capacitación</p>
            </div>
        </div>
        
        <a href="LogoutServlet" class="logout-btn">Cerrar Sesión</a>
    </div>
</body>
</html>