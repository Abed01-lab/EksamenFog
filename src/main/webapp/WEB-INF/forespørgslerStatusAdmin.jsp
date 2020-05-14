<%--
  Created by IntelliJ IDEA.
  User: cecilie
  Date: 06/05/2020
  Time: 15.06
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
    <title>Forespørgsler status</title>
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


    <div class="mt-5">
        <h5 class="mb-3"></h5>
        <table class="table table-bordered table-hover">
            <thead>
            <tr>
                <th scope="col">Forespørgsel nr.</th>
                <th scope="col">Kundenavn</th>
                <th scope="col"></th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="element" items="${applicationScope.kundeForepørgsler}">
                <tr>
                    <td>${element.forespørgselsId}</td>
                    <td>${element.fornavn} ${element.efternavn}</td>

                    <td>
                        <div align="center">
                            <form action="FrontController" method="post">
                                <input type="hidden" name="target" value="AdminSeForespørgsel">
                                <input type="hidden" name="forespørgselsId" value="${element.forespørgselsId}">
                                <button type="submit" class="btn btn-primary">Se forespørgsel</button>
                            </form>
                        </div>

                    </td>
                    <display:column>
                        <c:choose>
                            <c:when test="${element.status == 1}">
                                <td>
                                <p>Godkendt - Se under ordrer</p>
                                </td>

                                <td>

                                </td>
                            </c:when>
                            <c:when test="${element.status == -1}">
                                <td>

                                </td>

                                <td>
                                    <p>Forespørgsel er afvist</p>
                                </td>
                            </c:when>

                            <c:otherwise>
                                <td>
                                    <div align="center">
                                        <form action="FrontController" method="post">
                                            <input type="hidden" name="target" value="AdminAccepterForespørgsel">
                                            <input type="hidden" name="forespørgselsId" value="${element.forespørgselsId}">
                                            <button type="submit" class="btn btn-success">Godkend</button>
                                        </form>
                                    </div>
                                </td>

                                <td>
                                    <div align="center">
                                        <form action="FrontController" method="post">
                                            <input type="hidden" name="target" value="AdminAfvisForespørgsel">
                                            <input type="hidden" name="forespørgselsId" value="${element.forespørgselsId}">
                                            <button type="submit" class="btn btn-danger">Afvis</button>
                                        </form>

                                    </div>
                                </td>
                            </c:otherwise>
                        </c:choose>
                    </display:column>


                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
