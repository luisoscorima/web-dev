<%@page contentType="text/html" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Vista Cliente - 123 Digital</title>
    <link rel="stylesheet" type="text/css" href="css/cliente-vista-styles.css">
</head>
<body>
    <!-- Barra superior -->
    <header class="top-bar">
        <div class="logo">123 Digital</div>
        <nav class="top-nav">
            <a href="#" class="nav-item">Inicio</a>
            <a href="#" class="nav-item">Notificaciones</a>
            <a href="#" class="nav-item">Perfil</a>
            <a href="#" class="nav-item">Cerrar Sesión</a>
        </nav>
    </header>

    <!-- Barra lateral -->
    <aside class="sidebar">
        <div class="user-profile">
            <div class="avatar">BR</div>
            <div class="user-info">
                <span class="user-name">Brent Rodriguez</span>
                <span class="user-role">Cliente</span>
            </div>
        </div>
        
        <nav class="side-nav">
            <a href="#" class="nav-link active">
                <span class="nav-icon">📋</span>
                <span>Mis Solicitudes</span>
            </a>
            <a href="crear-ticket.jsp" class="nav-link">
                <span class="nav-icon">➕</span>
                <span>Crear Ticket</span>
            </a>
        </nav>
    </aside>

    <!-- Contenido principal -->
    <main class="main-content">
        <div class="content-header">
            <h1>Mis solicitudes</h1>
        </div>

        <div class="resumen-solicitudes">
            <span class="resumen-item">Mis Solicitudes <span class="contador">3</span></span>
        </div>

        <div class="tabla-tickets-container">
            <table class="tabla-tickets">
                <thead>
                    <tr>
                        <th width="20%">Nº DE TICKET</th>
                        <th width="20%">ASUNTO</th>
                        <th width="15%">TIPO</th>
                        <th width="15%">PRIORIDAD</th>
                        <th width="15%">ESTADO</th>
                        <th width="15%">FECHA</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="checkbox" name="ticket" value="001"> TKT-001</td>
                        <td>Problema con contraseña</td>
                        <td>Soporte</td>
                        <td><span class="prioridad-alta">Alta</span></td>
                        <td><span class="estado-pendiente">Pendiente</span></td>
                        <td>14/11/2022</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="ticket" value="002"> TKT-002</td>
                        <td>Instalación de software</td>
                        <td>Desarrollo</td>
                        <td><span class="prioridad-media">Media</span></td>
                        <td><span class="estado-progreso">En Progreso</span></td>
                        <td>15/11/2022</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="ticket" value="003"> TKT-003</td>
                        <td>Error en sistema</td>
                        <td>Soporte</td>
                        <td><span class="prioridad-alta">Alta</span></td>
                        <td><span class="estado-pendiente">Pendiente</span></td>
                        <td>16/11/2022</td>
                    </tr>
                </tbody>
            </table>

            <button class="btn-cargar-mas">Cargar más tickets</button>
        </div>
    </main>
</body>
</html>