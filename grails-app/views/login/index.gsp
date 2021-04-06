<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
</head>
<body>
<div class="col-xs-6">
    <h1>Familiares</h1>

    <ul class="list-group">
    <g:each in="${model.familiares}">
        <li class="list-group-item"><a href="/login/familiar?id=${it.id}">${it}</a></li>
    </g:each>
    </ul>
</div>

<div class="col-xs-6">
    <h1>Maestros</h1>

    <ul class="list-group">
        <g:each in="${model.maestros}">
            <li class="list-group-item"><a href="/login/maestro?id=${it.id}">${it}</a></li>
        </g:each>
    </ul>
</div>
</body>
</html>