<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <title>Mis Tickets</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
  <style>
    .card { margin: .5rem; }
    .status-open { background: #e6f9ee; color: #2d9a6f; }
  </style>
</head>
<body>
<div class="container-fluid">
  <h2>Total: <c:out value="${fn:length(tickets)}"/> Tickets</h2>
  <div class="row">
    <c:forEach var="t" items="${tickets}">
      <div class="col-md-4">
        <div class="card shadow-sm">
          <div class="card-body">
            <span class="badge status-open float-right">OPEN</span>
            <h5 class="card-title">${t.asunto}</h5>
            <p><strong>User:</strong> Colaborador ${sessionScope.userName}</p>
            <p><strong>Submitted:</strong> ${t.fechaCreacion}</p>
            <p><strong>Priority:</strong> ${t.prioridad}</p>
            <a href="ticketDetails?id=${t.idSolicitud}" class="stretched-link"></a>
          </div>
        </div>
      </div>
    </c:forEach>
  </div>
</div>
</body>
</html>
