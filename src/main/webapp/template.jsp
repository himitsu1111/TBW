<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<c:set var="adsJsp" value="${ads}" />
<head>

  <title>Make youre ad</title>
  <link href="css/css.css" rel="stylesheet">
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"--%>
  <%--integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">--%>
  <script src="https://yastatic.net/jquery/1.6.4/jquery.min.js"></script>
</head>

<body>

<div class="panel panel-primary">
  <div class="panel-heading">
    <%--<br>Search:<br>--%>


    <div class="row">
      <div class="col-xs-3">
        <form class="form-inline" action="/search" method="get">
          <div class="form-group">
            <%--<label for="exampleInputName2">Search</label>--%>
            <input type="text" name="query" class="form-control" placeholder="Search...">
          </div>
        </form>
      </div>
    </div>
    <button type="button" class="btn btn-default btn-lg active" onclick="location.href='/';">Home</button>
    <h1>${adn}</h1>
    <h4 align="right"><a href="/logout" class="widget-cat">Logout</a></h4>
  </div>

</div>

  <form action="/ad" class="form-horizontal col-md-6 col-md-offset-3" method="post">
    <div class="form-group">
      <%--заголовок, название услуги--%>
      <label>Header</label>
      <input type="text" name="header" id="h_id" class="form-control"
             placeholder="Type here header of youre ad" value="${adsJsp.header}" maxlength="">
    </div>
    <div class="form-group">
      <%--текст объявы--%>
      <label>Text of your ad</label>
      <textarea class="form-control" name="textField" id="t_id" rows="3"
                placeholder="input here substance of ad" maxlength="400">${adsJsp.textField}</textarea>
    </div>

    <div class="form-group">
      <label for="sell1">Select contact type:</label>
      <select class="form-control" name="contactName1" id="sell1">
        <c:forEach var="contacts" items="${listContacts}">
        <option>${contacts.name}</option>
        </c:forEach>
      </select>
    </div>

    <div class="form-group">
      <%--способ связи 1--%>
      <label>Contact #1</label>
      <input type="text" name="con1" class="form-control"
             placeholder="icq, telegram, skype, phone number, email, viber, whatsapp" value="${adsJsp.con1}">
    </div>

    <div class="form-group">
      <label for="sell2">Select contact type:</label>
      <select class="form-control" name="contactName2" id="sell2">
        <c:forEach var="contacts" items="${listContacts}">
          <option>${contacts.name}</option>
        </c:forEach>
      </select>
    </div>

    <div class="form-group">
      <%--способ связи 2--%>
      <label>Contact #2</label>
      <input type="text" name="con2" class="form-control"
             placeholder="icq, telegram, skype, phone number, email, viber, whatsapp" value="${adsJsp.con2}">
    </div>



    <%--<c:forEach var="contacts" items="${listContacts}">--%>

    <script>

      var v = document.getElementById("sell1");
      v.value = '${adsJsp.con_1_id}';

      var n = document.getElementById("sell2");
      n.value = '${adsJsp.con_2_id}';

    </script>

    <button type="submit" class="btn btn-default">Save</button>

  </form>

</body>
</html>
