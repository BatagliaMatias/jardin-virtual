<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
</head>

<body>
<div class="row">
    <div class="col-xs-12">
        <h1>${maestro.nombre} ${maestro.apellido}</h1>
        <h2>Mis salitas</h2>
        <div class="col-xs-12">
            <ul class="list-group">
                <g:each in="${salitas}">
                    <li class="list-group-item">
                        <a href="/webSalita/salita?id=${it.id}">${it.nombre} De ${it.edadMinima} años a ${it.edadMaxima} años con cupo ${it.cupo()}</a>
                    </li>
                </g:each>
            </ul>
        </div>

    </div>
</div>




</body>
</html>