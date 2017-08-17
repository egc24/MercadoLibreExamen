<!DOCTYPE html>
<html>
<head>
  <title>Examen Mercado Libre Eduardo Gonzalez Calderon</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  body {
      position: relative; 
  }
  #codigoFuente {padding-top:50px;height:500px;color: #fff; background-color: #ff9800;}
  #urlWebServices {padding-top:50px;height:500px;color: #fff; background-color: #1E88E5;}
  </style>
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Examen MercadoLibre - Eduardo Gonzalez Calderon</a>
    </div>
    <div>
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav">
          <li><a href="#codigoFuente">Codigo Fuente</a></li>
          <li><a href="#urlWebServices">URL Metodos Web Service</a></li>
        </ul>
      </div>
    </div>
  </div>
</nav>    

<div id="codigoFuente" class="container-fluid">
  <h1>Codigo Fuente</h1>
  <p>El codigo fuente incluyendo el script de base de datos, y el javadoc se encuentran en la siguiente url en github:</p>
  <p><strong><a href="https://github.com/egc24/MercadoLibreExamen">Codigo Fuente en Github</a></strong></p>
</div>
<div id="urlWebServices" class="container-fluid">
  <h1>URL Web Service</h1>
  <p>Los dos metodos solicitados se pueden acceder mediante las siguientes dos URL's (con los parametros solicitados de envio y recepcion):</p>
  <p><strong>http://amazontest24.sa-east-1.elasticbeanstalk.com/webservices/mutant</strong></p>
  <p>Enviando POST por ejemplo -> {"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]}</p>
  <p><strong>http://amazontest24.sa-east-1.elasticbeanstalk.com/webservices/stats</strong></p>
  <p>Enviando POST vacio y recibiendo por ejemplo -> {"count_mutant_dna":40, "count_human_dna":100: "ratio":0.4}</p>
</div>

</body>
</html>
