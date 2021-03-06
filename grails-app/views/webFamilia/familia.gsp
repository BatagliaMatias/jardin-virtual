<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
</head>

<body>
<div class="row">
    <div class="col-xs-12">
        <h1>${model.miFamilia} </h1>
    </div>
</div>

<div class="row">

    <div class="col-sm-6">
        <h2>Familiares Permanentes</h2>
        <ul class="list-group">
            <g:each in="${model.vinculosPermanentes}">
                <li class="list-group-item">${it.descripcion} ${it.familiar}</li>
            </g:each>
        </ul>
    </div>

    <div class="col-sm-6">
        <h2>Familiares Temporales</h2>
        <ul class="list-group">
            <g:each in="${model.vinculosTemporales}">
                <li class="list-group-item">${it.descripcion} ${it.familiar}
                    <g:if test="${model.soyPermanente}">
                        <a href="/webVinculoTemporal/extender?id=${it.id}&dias=30" class="botonTiempo btn btn-warning">+1 mes</a>
                        <a href="/webVinculoTemporal/extender?id=${it.id}&dias=7" class="botonTiempo btn btn-warning">+1 semana</a>
                        <a href="/webVinculoTemporal/extender?id=${it.id}&dias=1" class="botonTiempo btn btn-warning">+1 día</a>
                    </g:if>
                    <g:if test="${it.esActivo()}">
                        <a href="" class="botonTiempo btn  btn-success">${it.mostrarHasta()}</a>
                    </g:if>
                    <g:else>
                        <a href="" class="botonTiempo btn  btn-danger">${it.mostrarHasta()}</a>
                    </g:else>
                </li>
            </g:each>
        </ul>
    </div>
</div>
<div class="row">
    <div class="col-sm-12">
        <h2>Niños</h2>
        <ul class="list-group">
            <g:each in="${model.ninos}">
                <li class="list-group-item"><a href="/webNino/nino?id=${it.id}">${it}</a></li>
            </g:each>
        </ul>
    </div>
</div>
<div class="row">
    <div class="col-sm-12">
        <h2>Solicitudes pendientes</h2>
        <ul class="list-group">
            <g:each in="${model.solicitudes}">
                <li class="list-group-item clearfix">
                    <span style="display: inline-block; vertical-align: middle;">${it.familiar} - ${it.fecha}</span>
                    <a href="/webFamilia/rechazarSolicitud?idSolicitud=${it.id}" class="botonTiempo btn btn-danger">Rechazar</a>
                    <a href="/webFamilia/aceptarSolicitudTemporal?idSolicitud=${it.id}&dias=1" class="botonTiempo btn btn-warning">1 día</a>
                    <a href="/webFamilia/aceptarSolicitudTemporal?idSolicitud=${it.id}&dias=7" class="botonTiempo btn btn-warning">1 semana</a>
                    <a href="/webFamilia/aceptarSolicitudTemporal?idSolicitud=${it.id}&dias=30" class="botonTiempo btn btn-warning">1 mes</a>
                    <a class="botonTiempo disabled btn btn-warning">Temporal</a>
                    <a href="/webFamilia/aceptarSolicitudPermanente?idSolicitud=${it.id}" class="botonTiempo btn  btn-success">Permanente</a>
                </li>
            </g:each>
        </ul>
    </div>
</div>


</body>
</html>