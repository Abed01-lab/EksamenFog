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
    <title>Design af carport</title>
</head>
<body>

<div class="container">
    <div class="row">
        <img src="images/Fog-Header-7.png" class="img-fluid">


            <ul class="nav navbar justify-content-end w-100 py-0" style="background-color: #007cdc;">
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


    <h1>Velkommen til Fog!</h1>
    <p>${requestScope.error}</p>


 <%--   <div id="carouselExampleCaptions" class="carousel slide w-50" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
            <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="images/CarportMedFladtTagOgSkur.png" class="d-block w-100" alt="CarportMedFladtTagOgSkur">
                <div class="carousel-caption d-none d-md-block">
                    <h5>CARPORT ENKELT 3,00X6,00 M CAR01R FLADT TAG</h5>
                    <p>MED REDSKABSRUM 1,50X2,70 M</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="images/CarportMedRejsningUdenSkur.png" class="d-block w-100" alt="CarportMedRejsningUdenSkur">
                <div class="carousel-caption d-none d-md-block">
                    <h5>CARPORT ENKELT 3,60X5,40M CAR01H HØJ REJSNING</h5>
                    <p>Uden redskabsrum</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="images/CarportMedRejsningOgSkur.png" class="d-block w-100" alt="CarportMedRejsningOgSkur">
                <div class="carousel-caption d-none d-md-block">
                    <h5>CARPORT ENKELT 3,60X7,20M CAR01HR</h5>
                    <p>MED REDSKABSRUM 3,20X2,20M</p>
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
    </div>--%>



</div>
</body>
</html>
