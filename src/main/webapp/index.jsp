<%--
  Created by IntelliJ IDEA.
  User: cecilie
  Date: 21/04/2020
  Time: 15.10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
            integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
            crossorigin="anonymous"></script>
    <title>Design af carport</title>
</head>
<body>

<div class="container">
    <div class="row">
        <img src="images/Fog-Header-7.png" class="img-fluid">


        <ul class="nav navbar justify-content-end w-100 py-0" style="background-color: #007cdc;">
            <li class="nav-item ml-2">
                <form name="Forside" action="FrontController" method="post">
                    <input type="hidden" name="target" value="SeForside">
                    <input type="submit" class="btn btn-link" style="color: white" value="Forside">
                </form>
            </li>
            <li class="nav-item mr-auto">
                <form name="DesignCarport" action="FrontController" method="post">
                    <input type="hidden" name="target" value="GoToLavcarport">
                    <input type="submit" class="btn btn-link" style="color: white" value="Design carport">
                </form>
            </li>
            <li class="nav-item mr-2">
                <form name="OpdaterMaterialer" action="FrontController" method="post">
                    <input type="hidden" name="target" value="AdminPage">
                    <input type="submit" class="btn btn-link" style="color: white" value="Opdater materialer">
                </form>
            </li>
            <li class="nav-item mr-2">
                <form name="Forespørgsler" action="FrontController" method="post">
                    <input type="hidden" name="target" value="AdminForespørgsler">
                    <input type="submit" class="btn btn-link" style="color: white" value="Forespørgsler">
                </form>
            </li>
            <li class="nav-item mr-2">
                <form name="Ordrer" action="FrontController" method="post">
                    <input type="hidden" name="target" value="AdminOrdrer">
                    <input type="submit" class="btn btn-link" style="color: white" value="Ordrer">
                </form>
            </li>
        </ul>
    </div>



    <p>${requestScope.error}</p>

    <div class="row mt-6">
        <div class="col-sm">
            <h1 class="mt-3">Velkommen!</h1>
            <h5 class="mt-5">KØB DIN NYE CARPORT HOS FOG</h5>
            <p>Vælg dine ønskede mål på en carport og lad os give dig et konkret tilbud på en carport i nøjagtig de mål,
                som du ønsker - med eller uden redskabsrum.</p>

            <h5 class="mt-5">CARPORT I TILPASSEDE MÅL</h5>
            <p>Med et specialudviklet computerprogram kan vi lynhurtigt beregne prisen og udskrive en skitsetegning på
                en carport indenfor vores standardprogram - i de mål du ønsker. Tilbud og skitsetegning fremsendes med
                post/email hurtigst muligt.</p>
        </div>
        <div class="col-sm">
            <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                    <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="images/CarportMedRejsningUdenSkur.png" class="d-block w-100" alt="CarportMedFladtTagOgSkur">
                        <div class="carousel-caption d-none d-md-block">
                            <h5 style="color: black">CARPORT ENKELT MED HØJ REJSNING</h5>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="images/CarportMedRejsningOgSkur.png" class="d-block w-100" alt="CarportMedRejsningUdenSkur">
                        <div class="carousel-caption d-none d-md-block">
                            <h5 style="color: black">CARPORT ENKELT MED HØJ REJSNING OG SKUR</h5>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="images/CarportMedFladtTagOgSkur.png" class="d-block w-100" alt="CarportMedRejsningOgSkur">
                        <div class="carousel-caption d-none d-md-block">
                            <h5 style="color: black">CARPORT ENKELT MED FLADT TAG OG SKUR</h5>
                        </div>
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Forrige</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Næste</span>
                </a>
            </div>

        </div>
    </div>




</div>
</body>
</html>
