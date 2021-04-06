<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta name="layout" content="main" />
</head>

<body>
<div class="row">
  <div class="col-xs-12">
    <h1>${nino.nombre} ${nino.apellido} de ${nino.edad} años</h1>
    <h2>Familia ${nino.familia}</h2>
    <g:if test="${estaInscripto}">
      <h3>${salita.nombre}</h3>
      <g:if test="${estaEsperandoAceptacion}">
        <h4>Su inscripción esta pendiente a que un maestro la apruebe</h4>
      </g:if>
      <g:else>
        mostrar contenido de la sala
      </g:else>
    </g:if>
    <g:else>
      <h3>Inscribirse en una salita</h3>
      <div class="col-xs-12">
        <ul class="list-group">
          <g:each in="${salitas}">
            <li class="list-group-item">${it.nombre} De ${it.edadMinima} a ${it.edadMaxima} con cupo ${it.cupo()}
              <a href="/webSalita/inscribirse?idSalita=${it.id}&idNino=${nino.id}" class="botonTiempo btn btn-success">Inscribirse</a>
            </li>
          </g:each>
        </ul>
      </div>
    </g:else>
  </div>
</div>




</body>
</html>