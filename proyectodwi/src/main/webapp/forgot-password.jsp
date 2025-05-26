<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Recuperar Contraseña - 123 Digital</title>
    <link rel="stylesheet" type="text/css" href="css/forgot-password-styles.css">
</head>
<body>
    <div class="overlay" id="passwordResetOverlay">
        <div class="password-reset-popup">
            <h2>Genera una nueva contraseña</h2>
            
            <form id="passwordResetForm" action="PasswordResetServlet" method="POST">
                <div class="form-group">
                    <label for="email">Correo Electrónico</label>
                    <input type="email" id="email" name="email" placeholder="Ingresa tu correo" required>
                </div>
                
                <div class="form-actions">
                    <button type="button" class="btn-cancel" onclick="closePopup()">Cancelar</button>
                    <button type="submit" class="btn-submit">Cambiar Contraseña</button>
                </div>
            </form>
        </div>
    </div>

    <script>
        function closePopup() {
            window.location.href = "index.jsp"; // Redirige a la página principal
        }
    </script>
</body>
</html>