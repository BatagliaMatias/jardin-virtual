<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
</head>

<body>
<div class="row">
    <div class="col-xs-12">
        <h1>${salita.nombre} </h1>

        <g:if test="${!inscripcionesPendientes.isEmpty()}">
            <h2>Inscripciones pendientes (cupo actual: ${salita.cupo()})</h2>
            <div class="col-xs-12">
                <ul class="list-group">
                    <g:each in="${inscripcionesPendientes}">
                        <li class="list-group-item">
                            ${it.nino.nombre} ${it.nino.apellido} de ${it.nino.edad} años  <a href="/webSalita/aceptar?idInscripcion=${it.id}" class="botonTiempo btn btn-success">Aceptar</a>
                        </li>
                    </g:each>
                </ul>
            </div>
        </g:if>

        <g:if test="${!ninos.isEmpty()}">
            <h2>Niños</h2>
            <div class="col-xs-12">
                <ul class="list-group">
                    <g:each in="${ninos}">
                        <li class="list-group-item">
                            ${it.nombre} ${it.apellido} de ${it.edad} años
                        </li>
                    </g:each>
                </ul>
            </div>
        </g:if>

        <g:if test="${!actividadesAbiertas.isEmpty()}">
            <h2>Actividades abiertas</h2>
            <div class="col-xs-12">
                <ul class="list-group">
                    <g:each in="${actividadesAbiertas}">
                        <li class="list-group-item">
                            <a href="/webActividad/actividad?id=${it.id}">${it.consigna}</a>
                        </li>
                    </g:each>
                </ul>
            </div>
        </g:if>
        <div class="col-xs-12">
            <h1>Crear nueva actividades</h1>
            <g:form name="actividad" url="[action:'list',controller:'actividad']">
                <label for="consigna">Consigna:</label>
                <g:textArea name="consigna"  rows="5" cols="40"/>
                <label for="inicio">Inicio:</label>
                <g:datePicker name="inicio" value="${new Date()}"
                              precision="day" />
                <label for="fin">Fin:</label>
                <g:datePicker name="fin" value="${new Date()}"
                              precision="day" />
            </g:form>
        </div>

    </div>
</div>




</body>
</html>