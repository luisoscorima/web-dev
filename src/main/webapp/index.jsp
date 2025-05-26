<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Bienvenido a 123Digit@l</title>
    <link rel="stylesheet" type="text/css" href="css/index-styles.css">
</head>
<body>
    
    <div class="login-container">
        <h1>Bienvenido a 123Digit@l</h1>
        <p>Accede para gestionar tus solicitudes de soporte, desarrollo y capacitación.</p>
        
        <% if (request.getAttribute("errorMessage") != null) { %>
            <div class="error-message">
                <%= request.getAttribute("errorMessage") %>
            </div>
        <% } %>
        
        <form action="LoginServlet" method="POST">
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required>
            </div>
            
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            
            <button type="submit" class="btn-signin">Sign In</button>
        </form>
        
        <div class="forgot-password">
            <a href="forgot-password.jsp">Forgot password?</a>
        </div>
        
        <div class="register-link">
            <p>¿No tienes cuenta? <a href="register.jsp">Regístrate aquí</a></p>
        </div>
    </div>
</body>
</html>