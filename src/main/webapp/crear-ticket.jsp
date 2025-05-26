<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vista Cliente - 123 Digital</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/cliente-vista-styles.css">
    <link rel="stylesheet" href="../css/estilos_solicitud.css">
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
        <div class="avatar">BR</div>
        <div class="user-info">
            <span class="user-name">Brent Rodriguez</span>
            <span class="user-role">Cliente</span>
        </div>
    </div>

    <nav class="side-nav">
        <a href="cliente-vista.jsp" class="nav-link">
            <span class="nav-icon">📋</span>
            <span>Mis Solicitudes</span>
        </a>
        <a href="#" class="nav-link active">
            <span class="nav-icon">➕</span>
            <span>Crear Ticket</span>
        </a>
    </nav>
</aside>

<!-- Contenido principal -->
<main class="main-content">
    <div class="container mt-5 mb-5">
        <h2 class="mb-3">Registrar nueva solicitud</h2>
        <p class="text-muted">Los campos obligatorios están marcados con un <span class="text-danger">*</span></p>
        <form action="../RegistrarSolicitudServlet" method="post" id="formularioSolicitud">
            <div class="row mb-3">
                <div class="col-md-6">
                    <label class="form-label">Nombre <span class="text-danger">*</span></label>
                    <input type="text" class="form-control" name="nombre">
                </div>
                <div class="col-md-6">
                    <label class="form-label">Teléfono <span class="text-danger">*</span></label>
                    <input type="text" class="form-control" name="telefono">
                </div>
            </div>

            <div class="mb-3">
                <label class="form-label">Asunto <span class="text-danger">*</span></label>
                <input type="text" class="form-control" name="asunto">
            </div>

            <div class="row mb-3">
                <div class="col-md-6 d-flex flex-column gap-3">
                    <div>
                        <label class="form-label">Aplicativo</label>
                        <input type="text" class="form-control" name="aplicativo">
                    </div>
                    <div>
                        <label class="form-label">Tipo de Solicitud <span class="text-danger">*</span></label>
                        <select class="form-select" name="tipoSolicitud">
                            <option value="">Seleccionar</option>
                            <option value="1">Error</option>
                            <option value="2">Capacitación</option>
                            <option value="3">Requerimiento</option>
                        </select>
                    </div>
                    <div>
                        <label class="form-label">Prioridad</label>
                        <select class="form-select" name="prioridad">
                            <option value="A">Alta</option>
                            <option value="M">Media</option>
                            <option value="B">Baja</option>
                        </select>
                    </div>
                </div>

                <div class="col-md-6">
                    <label class="form-label">Descripción <span class="text-danger">*</span></label>
                    <textarea class="form-control" name="motivo" rows="10"></textarea>
                </div>
            </div>

            <div class="text-end mt-4">
                <button type="submit" class="btn btn-success">Enviar</button>
            </div>
        </form>
    </div>
</main>

<!-- SweetAlert2 y validación -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script>
document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("formularioSolicitud");

    form.addEventListener("submit", function (event) {
        const nombre = form.nombre.value.trim();
        const telefono = form.telefono.value.trim();
        const asunto = form.asunto.value.trim();
        const descripcion = form.motivo.value.trim();
        const tipo = form.tipoSolicitud.value.trim();

        if (!nombre || !telefono || !asunto || !descripcion || !tipo) {
            event.preventDefault();

            Swal.fire({
                icon: "warning",
                title: "¡Faltan datos!",
                text: "Por favor completar todos los campos obligatorios.",
                confirmButtonColor: "#39c3a3"
            });
        }
    });
});
</script>

<script>

   // Confirmación si se registró el ticket
    const params = new URLSearchParams(window.location.search);
    const ticketId = params.get("ticketId");

    if (ticketId) {
        Swal.fire({
            icon: "success",
            title: "¡Solicitud registrada!",
            html: "Tu ticket N.º <strong>" + ticketId + "</strong> fue creado con éxito.<br>Un colaborador se pondrá en contacto contigo.",
            confirmButtonColor: "#39c3a3"
        });
    }
});
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
