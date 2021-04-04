<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
</head>

<body>
<div class="col-xs-6">
    <h1>Mis Familias</h1>

    <ul class="list-group">
        <g:each in="${model.misVinculos}">
            <li class="list-group-item"><a href="/webFamilia/familia?idVinculo=${it.id}">${it}</a></li>
        </g:each>
    </ul>

    <h2>Crear nueva familia</h2>
    <form action="/webFamilia/crearFamilia" method="post">
        <div class="form-group">
            <label for="nombre">Nombre:</label>
            <input type="text" class="form-control" name="nombre" id="nombre">
        </div>
        <div class="form-group">
            <label for="vinculo">Vinculo:</label>
            <input type="text" class="form-control" name="vinculo" id="vinculo">
        </div>
        <input type="submit" class="btn btn-default" value="Crear"/>
    </form>
</div>

<div class="col-xs-6">
    <h1>Otras Familias</h1>

    <ul class="list-group">
        <g:each in="${model.otrasFamilias}">
            <li class="list-group-item"><a href="/webFamilia?id=${it.id}">${it}</a></li>
        </g:each>
    </ul>
</div>

</body>
</html>