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
    </div>

    <div class="col-lg-12 w-100 h-100 p-3 mt-2" style="background-color: white;">
        <h2>Materialeopdatering</h2>
        <h4>- Her kan du tilføje materialer, opdaterer materialepriser og fjerne materialer!</h4>

        <h5 class="mt-5">Opdater pris</h5>
        <div class="form-row mt-4">

            <div class="col-6">
                <select class="form-control" name="length">
                    <c:forEach var="element" items="${applicationScope.længde}">
                        <option value="materialenavn">Mahognitræ stolper</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-4">
                <input type="text" class="form-control" placeholder="Skriv ny pris her">
            </div>

            <div class="col-2">
                <button type="submit" class="btn btn-primary float-right ">Opdater pris</button>
            </div>
        </div>

        <form action="FrontController" method="post">
            <input type="hidden" name="target" value="OpdaterMateriale">

            <h5 class="mt-5" style="color: black">Tilføj materiale</h5>

            <p></p>



            <div class="form-row mt-4">
                <div class="col-6">
                    <input type="text" name="enhed" class="form-control" placeholder="Enhed">
                </div>
                <div class="col-4">
                    <input type="text" name="pris" class="form-control" placeholder="Pris">
                </div>
            </div>

            <div class="form-row mt-4">
                <div class="col-10">
                    <input type="text" name="beskrivelse" class="form-control" placeholder="Navn og beskrivelse af materiale">
                </div>
                <div class="col-2">
                    <button type="submit" class="btn btn-success float-right"> Tilføj materiale</button>
                </div>
            </div>


        </form>





        <div class="mt-5">
            <h5 class="mb-3">Se og fjern materiale</h5>
            <table class="table table-bordered table-hover">
                <thead>
                <tr>
                    <th scope="col">ID serienummer</th>
                    <th scope="col">Materiale</th>
                    <th scope="col">Dimensioner</th>
                    <th scope="col">Beskrivelse</th>
                    <th scope="col">Pris</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">1234567</th>
                    <td>Stolpe</td>
                    <td>29x29</td>
                    <td>Mahognitræ</td>
                    <td>120,-</td>
                    <td>
                        <div class="float-right">
                            <button type="submit" class="btn btn-danger">Fjern</button>
                        </div>
                    </td>

                </tr>
                <tr>
                    <th scope="row">1234568</th>
                    <td>Spær</td>
                    <td>12x12</td>
                    <td>Lange</td>
                    <td>110,-</td>
                    <td><div class="float-right">
                        <button type="submit" class="btn btn-danger">Fjern</button>
                    </div></td>
                </tr>

                </tbody>
            </table>
        </div>


    </div>
</div>


</body>
</html>
