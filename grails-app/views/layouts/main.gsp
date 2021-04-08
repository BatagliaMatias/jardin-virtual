<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="canonical" href="https://getbootstrap.com/docs/3.3/examples/starter-template/">
    <title>
        <g:layoutTitle default="Jardín Virtual"/>
    </title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

    <asset:stylesheet src="bootstrap.css"/>
    <asset:stylesheet src="bootstrap-theme.css.css"/>
    <asset:stylesheet src="starter-template.css"/>
    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Jardín Virtual</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/login/">Login</a></li>
                <g:if test="${session.user != null && session.user instanceof jardin.virtual.Familiar}">
                    <li><a href="/webFamilia/">Familias</a></li>
                </g:if>
                <g:if test="${session.user != null && session.user instanceof jardin.virtual.Maestro}">
                    <li><a href="/webMaestro/maestro/">Salitas</a></li>
                </g:if>
            </ul>


            <span style="color: white;line-height: 50px;float:right;">Usuario ${session.user ?: "No logueado"}</span>
        </div><!--/.nav-collapse -->

    </div>
</nav>
<div class="container">
<g:layoutBody/>

</div><!-- /.container -->
<div class="footer row" role="contentinfo">
    <div class="col-xs-12">
        <span class="center-block text-center">Matías Bataglia 95354 matubat91@gmail.com - 75.71 Seminario de Ing. en Informática I - TP Jardin Virtual</span>
    </div>
</div>


<!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>-->
<!-- Latest compiled and minified JavaScript -->
<asset:javascript src="jquery-3.3.1.min.js"/>
<asset:javascript src="bootstrap.js"/>

<asset:javascript src="application.js"/>


</body>
</html>
