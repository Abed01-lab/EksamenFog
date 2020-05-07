<%--
  Created by IntelliJ IDEA.
  User: Mathias
  Date: 5/3/2020
  Time: 12:27 PM
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
    <title>Ordrebekræftelse</title>
</head>
<body>

<div class="container">
    <div class="row">
        <img src="images/Fog-Header-7.png" class="img-fluid">

        <ul class="nav navbar justify-content-end w-100" style="background-color: #007cdc;">
            <li class="nav-item mr-2">
                <form name="MyProfile" action="FrontController" method="post">
                    <input type="hidden" name="target" value="Admin">
                    <input type="submit" class="btn btn-link" style="color: white" value="Admin">
                </form>

            </li>
        </ul>
    </div>
    <h2> Ordre godkendt!</h2>
    <h4> Din ordre er godkendt, og bliver leveret til din adresse inden 5 hverdage</h4>
</div>


</body>
</html>
