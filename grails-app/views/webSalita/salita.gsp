<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
    <!--https://github.com/dmitriy-drenkalyuk/dynamic-blocks-taglib-->
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
            <h1>Crear nueva actividad</h1>

            <g:form method="post" name="actividad" url="/webActividad/crear">
                <label for="inicio">Inicio:</label>
                <input type="datetime-local" name="inicio" id="inicio">
                <label for="fin">Fin:</label>
                <input type="datetime-local" name="fin" id="fin">
                <br>
                <label style="margin-top: 10px" for="consigna">Consigna:</label>
                <g:textArea name="consigna"  rows="3" style="width:100%;margin-bottom: 10px"/>
                <br>
                <label for="fotos">Fotos (una uri por linea)</label>
                <g:textArea name="fotos"  rows="3" style="width:100%;margin-bottom: 10px"/>
                <br>
                <label for="videos">Videos (una uri por linea)</label>
                <g:textArea name="videos"  rows="3" style="width:100%;margin-bottom: 10px"/>
                <br>
                <label for="descargables">Descargables (una uri por linea)</label>
                <g:textArea name="descargables"  rows="3" style="width:100%;margin-bottom: 10px"/>
                <br>
                <g:hiddenField name="salita" value="${salita.id}"/>
                <g:actionSubmit action="crear" value="Crear actividad"/>
            </g:form>
        </div>

    </div>
</div>




</body>
</html>