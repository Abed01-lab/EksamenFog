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

        <ul class="nav navbar justify-content-end w-100" style="background-color: #007cdc;">
            <li class="nav-item mr-auto">
                <form name="logout" action="FrontController" method="post">
                    <input type="hidden" name="target" value="logout">
                    <input type="submit" class="btn btn-link" style="color: white" value="Log ud">

                </form>
            </li>
            <li class="nav-item mr-2">
                <form name="MyProfile" action="FrontController" method="post">
                    <input type="hidden" name="target" value="MyProfile">
                    <input type="submit" class="btn btn-link" style="color: white" value="Min profil">
                </form>

            </li>
        </ul>
        <div class="col-lg-12 w-100 h-100 p-3 mt-2" style="background-color: white;">
            <form action="FrontController" method="post">
                <input type="hidden" name="target" value="LavCarport">
                <h2 style="color: black">Velkommen! </h2>
                <h4 style="color: black">Design din egen carport her: </h4>
                <!--<br>
                <p style= "font-style: italic">${requestScope.besked}</p>-->
                <div class="row mt-4">
                    <div class="col-sm">
                        <p>Længde</p>
                        <select class="form-control" name="længde">
                            <c:forEach var="element" items="${applicationScope.længde}">
                                <option value="${element}">${element}cm</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-sm">
                        <p>Tag</p>
                        <select class="form-control" name="tag">
                            <c:forEach var="element" items="${applicationScope.tag}">
                                <option value="${element}">${element} </option>
                            </c:forEach>
                        </select>
                    </div>


                </div>
                <div class="row mt-4">
                    <div class="col-sm-6">
                        <p>Bredde</p>
                        <select class="form-control" name="bredde">
                            <c:forEach var="element" items="${applicationScope.bredde}">
                                <option value="${element}">${element}cm</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-sm-6">
                        <p>Tag hældning</p>
                        <select class="form-control" name="taghældning">
                            <c:forEach var="element" items="${applicationScope.taghældning}">
                                <option value="${element}">${element}%</option>
                            </c:forEach>
                        </select>
                    </div>


                </div>
                <div class="row mt-4">
                    <div class="col-sm-6">
                        <p>Højde</p>
                        <select class="form-control" name="højde">
                            <c:forEach var="element" items="${applicationScope.højde}">
                                <option value="${element}">${element}cm</option>
                            </c:forEach>
                        </select>
                    </div>
                    <!--<div class="col-sm-6">
                        <p>Redskabsskur</p>
                        <select class="form-control" name="toolshed">
                            <c:forEach var="element" items="${applicationScope.taghældning}">
                                <option value="400">200 cm</option>
                            </c:forEach>
                        </select>
                    </div>-->
                </div>
                    <br>
                    <br>
                    <h4 style="color: black">Tilvælg skur: </h4>
                    <div class="row mt-4">
                        <div class="col-sm-6">
                            <p>Skur længde</p>
                            <select class="form-control" name="skurlængde">
                                <c:forEach var="element" items="${applicationScope.skurlængde}">
                                    <option value="${element}">${element}cm</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-sm-6">
                        <p>Skur bredde</p>
                        <select class="form-control" name="skurbredde">
                            <c:forEach var="element" items="${applicationScope.skurbredde}">
                                <option value="${element}">${element}cm</option>
                            </c:forEach>
                        </select>
                    </div>

                    </div>

                <div class="float-right mt-4">
                    <button type="submit" class="btn btn-primary">Se tegning</button>
                </div>





            </form>
        </div>
        <div class="col-lg"></div>
    </div>
</div>
</body>
</html>
