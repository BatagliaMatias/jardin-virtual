<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
</head>

<body>
<div class="row">
    <div class="col-xs-12">
        <h1>${model.miFamilia}</h1>
    </div>
</div>

<div class="row">
    <div class="col-sm-6">
        <h2>Familiares</h2>
        <ul class="list-group">
            <g:each in="${model.vinculos}">
                <li class="list-group-item">${it.descripcion} ${it.familiar}</li>
            </g:each>
        </ul>
    </div>

    <div class="col-sm-6">
        <h2>Niños</h2>
        <ul class="list-group">
            <g:each in="${model.ninos}">
                <li class="list-group-item"><a href="/webFamilia?id=${it.id}">${it}</a></li>
            </g:each>
        </ul>
    </div>
</div>
<div class="row">
    <div class="col-sm-6">
        <h2>Solicitudes pendientes</h2>
        <ul class="list-group">
            <g:each in="${model.solicitudes}">
                <li class="list-group-item"><a href="/webFamilia?id=${it.id}">${it}</a></li>
            </g:each>
        </ul>
    </div>
</div>


</body>
</html>