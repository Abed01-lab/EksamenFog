<%--
  Created by IntelliJ IDEA.
  User: cecilie
  Date: 06/05/2020
  Time: 15.06
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
                <th scope="col">Tilbud nr.</th>
                <th scope="col">Kunde (email)</th>
                <th scope="col"></th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">1234567</th>
                <td>test@test.com</td>

                <td>
                    <div align="center">
                        <form action="FrontController" method="post">
                            <input type="hidden" name="target" value="AdminSeForespørgsel">
                            <button type="submit" class="btn btn-primary">Se forespørgsel</button>
                        </form>
                    </div>

                </td>
                <td>
                    <div align="center">
                        <form action="FrontController" method="post">
                            <input type="hidden" name="target" value="">
                            <button type="submit" class="btn btn-success">Godkend/Send tilbud</button>
                        </form>
                    </div>
                </td>

                <td>
                    <div align="center">
                        <form action="FrontController" method="post">
                            <input type="hidden" name="target" value="">
                            <button type="submit" class="btn btn-danger">Afvis</button>
                        </form>

                    </div>
                </td>

            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
