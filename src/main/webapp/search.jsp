<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search result</title>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%--<c:set var="resultJ" value="${result}" />--%>

<div class="panel panel-primary">
  <div class="panel-heading">
    <%--<br>Search:<br>--%>
    <div class="row">
      <div class="col-xs-3">
        <%--<input type="text" class="form-control">--%>
        <form class="form-inline" action="/search" method="get">
          <div class="form-group">
            <%--<label for="exampleInputName2">Search</label>--%>
            <input type="text" name="query" class="form-control" placeholder="Search...">
          </div>
        </form>

      </div>
    </div>
    <button type="button" class="btn btn-default btn-lg active" onclick="location.href='/';">Home</button>
  </div>
</div>

<div class="row">
  <div class="col-md-6">
    <%--<ul>--%>
    <c:forEach var="tempAd" items="${result}">


        <%--<li>${tempAd.header}</li>--%>
      <button type="button" class="btn btn-link" onclick="location.href='/${tempAd.adname}';">${tempAd.header}</button>

    </c:forEach>
    <%--</ul>--%>
  </div>
</div>
</body>
</html>
