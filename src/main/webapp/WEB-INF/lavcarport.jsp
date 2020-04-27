<%--
  Created by IntelliJ IDEA.
  User: gustav
  Date: 21-04-2020
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form action="FrontController" method="post">
    <input type="hidden" name="target" value="LavCarport">
    <div class="row mt-4">
        <div class="col-sm">
            <select class="form-control" name="bredde">
                <c:forEach var="element" items="${applicationScope.bredde}" varStatus="loop">
                    <option value="${element}">${element}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-sm">
            <select class="form-control" name="længde">
                <c:forEach var="element" items="${applicationScope.længde}">
                    <option value="${element}">${element}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-sm">
            <select class="form-control" name="højde">
                <c:forEach var="element" items="${applicationScope.højde}">
                    <option value="${element}">${element}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-sm">
            <select class="form-control" name="tag">
                <c:forEach var="element" items="${applicationScope.tag}">
                    <option value="${element}">${element}</option>
                </c:forEach>
            </select>
        </div>

        <div class="col-sm">
            <button type="submit" class="btn btn-primary">Lav carport</button>
        </div>
    </div>
</form>

</body>
</html>
