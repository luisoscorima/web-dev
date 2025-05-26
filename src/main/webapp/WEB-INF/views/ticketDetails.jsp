<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <title>Detalle de Ticket</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
  <a href="tickets" class="btn btn-link">&larr; Volver</a>
  <h3>Ticket #${detalle.idSolicitud} - ${detalle.asunto}</h3>
  <div class="row">
    <div class="col-md-8">
      <table class="table table-borderless">
        <tr><th>User</th><td>${detalle.nombreCliente} ${detalle.apellidoCliente}</td></tr>
        <tr><th>Submitted</th><td>${detalle.fechaCreacion}</td></tr>
        <tr><th>Status</th><td>${detalle.estado}</td></tr>
        <tr><th>Priority</th><td>${detalle.prioridad}</td></tr>
        <tr><th>Type</th><td>${detalle.tipoSolicitud}</td></tr>
      </table>
      <h5>Issue</h5>
      <p>${detalle.motivo}</p>

      <h5>Actividades</h5>
      <ul class="list-group">
        <c:forEach var="act" items="${detalle.actividades}">
          <li class="list-group-item">
            ${act.descripcion} 
            <small>(${act.inicio} - <c:out value="${act.fin != null ? act.fin : 'En curso'}"/>)</small>
          </li>
        </c:forEach>
      </ul>
    </div>
    <div class="col-md-4">
      <div class="card p-3">
        <h6>Assignee</h6>
        <p>Deanna Jones</p>
        <button class="btn btn-outline-primary btn-block">Choose Assignee</button>
        <hr/>
        <h6>Status</h6>
        <select class="form-control">
          <option>Open</option><option>In Progress</option><option>Solved</option>
        </select>
        <h6 class="mt-3">Priority</h6>
        <select class="form-control">
          <option>Lowest</option><option>Low</option><option>Medium</option><option>High</option><option>Highest</option>
        </select>
        <button class="btn btn-success btn-block mt-4">Add Response</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>
