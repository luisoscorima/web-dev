<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registro - 123 Digital</title>
    <link rel="stylesheet" type="text/css" href="css/register-styles.css">
</head>
<body>
    <div class="register-container">
        <h1>Registro de Usuario</h1>
        <p>Crea una cuenta para acceder a nuestros servicios</p>
        
        <% if (request.getAttribute("errorMessage") != null) { %>
            <div class="error-message">
                <%= request.getAttribute("errorMessage") %>
            </div>
        <% } %>
        
        <form action="RegisterServlet" method="POST">
            <div class="form-group">
                <label for="name">Nombre Completo</label>
                <input type="text" id="name" name="name" required>
            </div>
            
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required>
            </div>
            
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            
            <div class="form-group">
                <label for="confirmPassword">Confirmar Password</label>
                <input type="password" id="confirmPassword" name="confirmPassword" required>
            </div>
            
            <button type="submit" class="btn-register">Registrarse</button>
        </form>
        
        <div class="login-link">
            <p>¿Ya tienes cuenta? <a href="index.jsp">Inicia sesión aquí</a></p>
        </div>
    </div>
</body>
</html>