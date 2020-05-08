<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cecilie
  Date: 04/05/2020
  Time: 14.42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Materialeopdatering</title>
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
        <form action="FrontController" method="post">
            <input type="hidden" name="target" value="OpdaterPris">
            <h4>Materialeopdatering</h4>
            <h6 class="mt-4">Opdater pris</h6>
            <div class="form-row mt-4">

                <div class="col-6">
                    <select class="form-control" name="materialeId">
                        <c:forEach var="element" items="${applicationScope.materials}">
                            <option value="${element.itemId}">Serienummer ${element.itemId}
                                : ${element.beskrivelse}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-4">
                    <input type="text" name="pris" class="form-control" placeholder="Skriv ny pris her">
                </div>


                <div class="col-2">
                    <button type="submit" class="btn btn-primary float-right ">Opdater pris</button>
                </div>
            </div>
            ${requestScope.besked}
        </form>


        <form action="FrontController" method="post">
            <input type="hidden" name="target" value="OpdaterMateriale">

            <h6 class="mt-5" style="color: black">Tilføj materiale</h6>

            <p></p>


            <div class="form-row mt-4">
                <div class="col-10">
                    <input type="text" name="beskrivelse" class="form-control"
                           placeholder="Beskrivelse af materiale">
                </div>
            </div>

            <div class="form-row mt-4">
                <div class="col-6">
                    <select class="form-control" name="enhed">
                        <c:forEach var="element" items="${applicationScope.enhed}">
                            <option value="${element}">${element}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-4">
                    <input type="text" name="pris" class="form-control" placeholder="Pris">
                </div>
                <div class="col-2">
                    <button type="submit" class="btn btn-success float-right"> Tilføj materiale</button>
                </div>
            </div>

            ${requestScope.tilføjetMaterialeBesked}
        </form>


        <div class="mt-5">
            <h6 class="mb-3">Se og fjern materiale</h6>
            <table class="table table-bordered table-hover">
                <thead>
                <tr>
                    <th scope="col">Serienummer</th>
                    <th scope="col">Enhed</th>
                    <th scope="col">Beskrivelse</th>
                    <th scope="col">Pris</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="element" items="${applicationScope.materials}">
                    <tr>
                        <td>${element.itemId}</td>
                        <td>${element.enhed}</td>
                        <td>${element.beskrivelse}</td>
                        <td>${element.pris},-</td>
                        <td>
                            <div class="float-right">
                                <form action="FrontController" method="post">
                                    <input type="hidden" name="target" value="DeleteMaterial">
                                    <input type="hidden" name="serienummer" value="${element.itemId}">
                                    <button type="submit" class="btn btn-danger">Fjern</button>
                                </form>
                            </div>
                        </td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>


    </div>
</div>


</body>
</html>
