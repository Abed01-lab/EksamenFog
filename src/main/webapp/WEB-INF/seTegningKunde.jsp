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
    <title>Tegning af carport - send din forespørgsel her</title>
</head>
<body>

<div class="container">
    <div class="row">
        <img src="images/Fog-Header-7.png" class="img-fluid">

        <ul class="nav navbar justify-content-end w-100 py-0" style="background-color: #007cdc;">
            <li class="nav-item mr-2">
                <form name="Forespørgsler" action="FrontController" method="post">
                    <input type="hidden" name="target" value="AdminForespørgsler">
                    <input type="submit" class="btn btn-link" style="color: white" value="Forespørgsler">
                </form>
            </li>
            <li class="nav-item mr-2">
                <form name="OpdaterMaterialer" action="FrontController" method="post">
                    <input type="hidden" name="target" value="AdminPage">
                    <input type="submit" class="btn btn-link" style="color: white" value="Opdater materialer">
                </form>
            </li>
            <li class="nav-item mr-2">
                <form name="DesignCarport" action="FrontController" method="post">
                    <input type="hidden" name="target" value="GoToLavcarport">
                    <input type="submit" class="btn btn-link" style="color: white" value="Design carport">
                </form>
            </li>
        </ul>
    </div>

    <div class="col-lg-12 w-100 h-100 p-3 mt-2" style="background-color: white;">
        <h4>Tegning af carport</h4>

        <div>
            <p>TEGNING AF CARPORT</p>
        </div>

        <div class="form-group mt-4 my-1">
            <h4>Udfyld dine kontaktoplysninger her for at sende en forespørgsel på et tilbud!</h4>
            <div class="row">
                <div class="col">
                    <div class="row mt-4">
                        <input type="text" class="form-control" placeholder="Fornavn">
                    </div>
                    <div class="row mt-4">
                        <input type="text" class="form-control" placeholder="Efternavn">
                    </div>
                    <div class="row mt-4">
                        <input type="text" class="form-control" placeholder="Adresse">
                    </div>
                    <div class="row mt-4">
                        <input type="text" class="form-control" placeholder="Email">
                    </div>
                    <div class="row mt-4 mb-5">
                        <input type="text" class="form-control" placeholder="Telefonnummer">
                    </div>
                </div>
            </div>
        </div>


        <div class="col-2">
            <button type="submit" class="btn btn-primary float-right ">Send forespørgsel</button>
        </div>
    </div>

    </form>


</div>
</div>
</body>
</html>
