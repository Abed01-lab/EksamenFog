<%--
  Created by IntelliJ IDEA.
  User: cecilie
  Date: 06/05/2020
  Time: 15.05
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
    <title>Forespørgsler</title>
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
        <h5 class="mb-5">Forespørgsel #1242134</h5>
        <h4>Stykliste</h4>
        <table class="table table-bordered table-hover">
            <thead>
            <tr>
                <th scope="col">ID serienummer</th>
                <th scope="col">Materiale</th>
                <th scope="col">Længde</th>
                <th scope="col">Antal</th>
                <th scope="col">Beskrivelse</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">1234567</th>
                <td>Stolpe</td>
                <td>120 cm</td>
                <td>2 stk</td>
                <td>Mahognitræ</td>

            </tr>
            <tr>
                <th scope="row">1234567</th>
                <td>Stolpe</td>
                <td>100 cm</td>
                <td>4 stk</td>
                <td>Mahognitræ</td>
            </tr>

            </tbody>
        </table>
    </div>


    <h4 class="mt-5">Total pris </h4>
</div>
</body>
</html>
