<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
</head>

<body>
<div class="row">
    <div class="col-xs-6">
        <h1>Mis Familias</h1>

        <ul class="list-group">
            <g:each in="${model.misVinculos}">
                <li class="list-group-item"><a href="/webFamilia/familia?idFamilia=${it.familia.id}">${it}</a></li>
            </g:each>
        </ul>
    </div>
    <div class="col-xs-6">
        <h2>Nueva familia</h2>
        <form class="form-horizontal" action="/webFamilia/crearFamilia" method="post">
            <div class="form-group">
                <label class="control-label col-sm-2" for="nombre">Nombre:</label>
                <div class="col-sm-9">
                    <input  type="text" class="form-control" name="nombre" id="nombre">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="vinculo">Vinculo:</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" name="vinculo" id="vinculo">
                </div>
            </div>
            <button type="submit" class="btn btn-default" >Crear</button>
        </form>
    </div>
</div>

<div class="row">
    <div class="col-xs-6">
        <h1>Otras Familias</h1>

        <ul class="list-group">
            <g:each in="${model.otrasFamilias}">
                <li class="list-group-item">${it} <a class="botonSolicitar btn btn-primary <g:if test='${model.misFamiliasSolicitadas != null && model.misFamiliasSolicitadas.contains(it) }'>disabled</g:if>"  onclick="solicitarConVinculo(${it.id})" role="button"></a></li>
            </g:each>
        </ul>
    </div>
    <div class="col-xs-6">
        <h1>Mis solicitudes</h1>
        <ul class="list-group">
            <g:each in="${model.misSolicitudes}">
                <li class="list-group-item">${it.familia.nombre} - ${it.estado} - ${it.fecha} </li>
            </g:each>
        </ul>
    </div>
</div>

<script>
function solicitarConVinculo(idFamilia){
    var vinculo = prompt("¿Cuál es su vinculo con la familia?")
    while(vinculo.indexOf(' ') >= 0){
        vinculo = prompt("¿Cuál es su vinculo con la familia? (Sin espacios)")
    }
    window.location="/webFamilia/solicitarFamilia?id=" + idFamilia +"&vinculoSolicitud=" + vinculo
}

</script>

</body>
</html>