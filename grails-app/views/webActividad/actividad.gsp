<%@ page import="java.time.format.DateTimeFormatter" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
</head>

<body>
<div class="row">
    <div class="col-xs-12">
        <h1>${actividad.consigna}</h1>
        <h2>Del ${actividad.inicio.toLocalDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))} hasta el ${actividad.fin.toLocalDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))}</h2>
        <g:each in="${actividad.fotos}">
            <div class="col-xs-12">
                <img width="100%" alt="${it.uri}" src="${it.uri}">
            </div>
        </g:each>
        <g:each in="${actividad.videos}">
            <div class="col-xs-12">
                <iframe height="800px" width="100%" src="${it.uri}"></iframe>
            </div>
        </g:each>
        <div class="col-xs-12">
            <ul class="list-group">
                <g:each in="${actividad.descargables}">
                    <li class="list-group-item"><a target="_blank" href="${it.uri}">${it.uri}</a></li>
                </g:each>
            </ul>
        </div>

    </div>
</div>




</body>
</html>