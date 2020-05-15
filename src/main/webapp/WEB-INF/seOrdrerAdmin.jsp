<%--
  Created by IntelliJ IDEA.
  User: cecilie
  Date: 06/05/2020
  Time: 15.05
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


    <title>Ordrer</title>
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

        <h5 class="mt-5">Kundeordrer</h5>
        <table class="table table-bordered table-hover">
            <thead>
            <tr>
                <th scope="col">Ordrenummer</th>
                <th scope="col">Kundenavn</th>
                <th scope="col">Ordretidspunkt</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="element" items="${applicationScope.kundeOrdrer}">
                <tr>
                    <th scope="row">${element.ordreId}</th>
                    <td>${element.navn}</td>
                    <td>${element.dato}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</div>
</body>
</html>
