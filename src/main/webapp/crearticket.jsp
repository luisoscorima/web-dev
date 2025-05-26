<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registrar Solicitud</title>
</head>
<body>
<h2>Registrar nueva solicitud</h2>
<form action="../RegistrarSolicitudServlet" method="post">
    <label>Asunto:</label>
    <input type="text" name="asunto" required><br><br>
    <label>Motivo:</label>
    <textarea name="motivo" required></textarea><br><br>
    <label>Prioridad:</label>
    <select name="prioridad">
        <option value="A">Alta</option>
        <option value="M">Media</option>
        <option value="B">Baja</option>
    </select><br><br>
    <label>Tipo de solicitud:</label>
    <select name="tipoSolicitud">
        <option value="1">Error</option>
        <option value="2">Capacitación</option>
        <option value="3">Requerimiento</option>
    </select><br><br>
    <label>Aplicación (opcional):</label>
    <input type="number" name="idAplicacion"><br><br>
    <button type="submit">Registrar</button>
</form>
</body>
</html>
