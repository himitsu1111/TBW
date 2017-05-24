<%--
  Created by IntelliJ IDEA.
  User: secret
  Date: 11.04.2017
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Choose your ads</title>
  <link href="css/css.css" rel="stylesheet">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
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
  </div>
</div>


<ul class="nav nav-pills col-md-6 col-md-offset-3" role="tablist" style="margin-bottom: 50px ;">
  <li class="active"><a href="#home" role="tab" data-toggle="tab">Registration</a></li>
  <li><a href="#profile" role="tab" data-toggle="tab">Log in</a></li>
</ul>


<div class="tab-content">
  <div class="tab-pane fade in active" id="home">

    <form action="/settings" class="form-horizontal col-md-6 col-md-offset-3" method="post">
      <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <input type="email" name="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
      </div>
      <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
      </div>
      <div class="form-group">
        <label for="exampleInputPassword1">Ad name</label>
        <input type="text" name="adname" class="form-control" placeholder="your ad name">
      </div>
      <button type="submit" class="btn btn-default">Register</button>
    </form>

  </div>
  <div class="tab-pane fade" id="profile">

    <form action="/login" class="form-horizontal col-md-6 col-md-offset-3" method="post">
      <div class="form-group">
        <label for="exampleInputEmail2">Email address</label>
        <input type="email" name="emailL" class="form-control" id="exampleInputEmail2" placeholder="Email">
      </div>
      <div class="form-group">
        <label for="exampleInputPassword2">Password</label>
        <input type="password" name="passwordL" class="form-control" id="exampleInputPassword2" placeholder="Password">
      </div>
      <button type="submit" class="btn btn-default">Log in</button>
    </form>

  </div>
</div>

<%--<script>--%>
  <%--$('#myTabs a').click(function (e) {--%>
    <%--e.preventDefault()--%>
    <%--$(this).tab('${show}')--%>

  <%--})--%>
<%--</script>--%>

</body>
</html>
