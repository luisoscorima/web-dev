<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vista Cliente - 123 Digital</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/cliente-vista-styles.css">
    <link rel="stylesheet" href="css/estilos_solicitud.css">
</head>
<body>

<!-- Barra superior -->
<header class="top-bar">
    <div class="logo">123Digit@l</div>
    <nav class="top-nav">
        <a href="#" class="nav-item">Inicio</a>
        <a href="#" class="nav-item">Notificaciones</a>
        <a href="#" class="nav-item">Perfil</a>
        <a href="index.jsp" class="nav-item">Cerrar Sesión</a>
    </nav>
</header>

<!-- Barra lateral -->
<aside class="sidebar">
    <div class="user-profile">
        <div class="avatar">AD</div>
        <div class="user-info">
            <span class="user-name">Admin</span>
            <span class="user-role">Administrador</span>
        </div>
    </div>
    <nav class="side-nav">
        <a href="#" class="nav-link active">
            <span class="nav-icon">📊</span>
            <span>Dashboard</span>
        </a>
        <a href="#" class="nav-link">
            <span class="nav-icon">🎯</span>
            <span>Tickets</span>
        </a>
    </nav>
</aside>

<!-- Contenido principal -->
<main class="main-content">
    <div class="container py-4">
        <div class="row mb-4">
            <div class="col-md-6 dashboard-box text-center">
                <h5>Total Tickets</h5>
                <h1>2541</h1>
            </div>
            <div class="col-md-6 dashboard-box text-center">
                <h5>Total Tickets Asignados</h5>
                <h1>24</h1>
            </div>
        </div>

        <div class="row">
            <!-- Ticket List -->
            <div class="col-md-4 dashboard-box me-3">
                <h6 class="mb-3">Ticket List <span class="float-end"><a href="#">View All</a></span></h6>
                <div class="mb-3">
                    <div class="ticket-title">Password Not Working</div>
                    <div class="ticket-user">Brent Rodriguez</div>
                    <div class="d-flex justify-content-between align-items-center">
                        <span class="ticket-date">Nov 14, 2022</span>
                        <span class="ticket-status">OPEN</span>
                    </div>
                </div>
                <div class="mb-3">
                    <div class="ticket-title">Login Error</div>
                    <div class="ticket-user">Andrea Quispe</div>
                    <div class="d-flex justify-content-between align-items-center">
                        <span class="ticket-date">Nov 14, 2022</span>
                        <span class="ticket-status">OPEN</span>
                    </div>
                </div>
                <button class="btn btn-outline-secondary btn-sm w-100">Load More</button>
            </div>

            <!-- Assignee List -->
            <div class="col-md-4 dashboard-box me-3">
                <h6 class="mb-3">Assignee List <span class="float-end"><a href="#">View All</a></span></h6>
                <div class="mb-3">
                    <div class="ticket-title">Deanna Jones</div>
                    <div class="ticket-user">deanna@gmail.com</div>
                </div>
                <div class="mb-3">
                    <div class="ticket-title">Marco Gutiérrez</div>
                    <div class="ticket-user">marco@soporte.com</div>
                </div>
                <button class="btn btn-outline-secondary btn-sm w-100">Load More</button>
            </div>

            <!-- Most Recent Ticket -->
            <div class="col-md-3 dashboard-box">
                <h6 class="mb-3">Most Recent Ticket</h6>
                <p><strong>User:</strong> Brentrodriguez</p>
                <p><strong>Submitted:</strong> Nov 14, 2021 08:00</p>
                <p><strong>Subject:</strong> Password reset not working</p>
                <p><strong>Issue:</strong><br>Hi, I can’t seem to update the app. It says “Error checking updates” when I tried to update the app via Google Play. Pls help.</p>
                <button class="btn btn-outline-primary btn-sm">See Details</button>
            </div>
        </div>
    </div>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
