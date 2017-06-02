<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<c:set var="adsJsp" value="${ads}" />
<c:set var="adnJ" value="${adn}" />
<c:url var = "sendEmail" value="/mail">
	<c:param name="sendEmailToHim" value="${adsJsp.email}" />
	<%--<c:param name="sendEmailToMe" value="meSend" />--%>
</c:url>
<head>

    <title>${adsJsp.adname}</title>
  	<link href="css/css.css" rel="stylesheet">
  	<link href="css/bootstrap.min.css" rel="stylesheet">
	<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"--%>
		  <%--integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">--%>
	<script src="https://yastatic.net/jquery/1.6.4/jquery.min.js"></script>
</head>
<body>

<div class="panel panel-primary" id="mainpanel">
    <div class="panel-heading">
        <%--<br>Search:<br>--%>

		
		<div class="row">
		  <div class="col-md-2">
			  <form class="form-inline" action="/search" method="get">
				  <div class="form-group">
					  <%--<label for="exampleInputName2">Search</label>--%>
					  <input type="text" name="query" class="form-control" placeholder="Search...">
				  </div>
			  </form>
		  </div>

		</div>
		<div class="row">
		  <div class="col-md-1">
			<button type="button" class="btn btn-default btn-lg active" onclick="location.href='/';">Home</button>
		  </div>
		  <div class="col-md-1">
			  <h1>${adn}</h1>
		  </div>
		</div>
		<div class="row">
		  <div class="col-md-1">
			  <c:if test="${not empty adn}">
				  <h4 align="right" class="logoutH4"><a href="/logout" class="widget-cat">Logout</a></h4>
			  </c:if>
		  </div>
		</div>



    </div>
</div>

<br>
<label>Rating: </label>
<h4 id="rating_id">${adsJsp.rating}</h4>



<div class="widebox effect7">

	<p class="text-center" style="font-size: 26px">${adsJsp.header}</p>
	<%--<h3></h3>--%>
	<p class="lead" style="font-size: 18px; margin: 5px">${adsJsp.textField}</p><br>

		<p class="mytextsmall" style="font-size: 14px;">${adsJsp.con1}</p><br>
		<p class="mytextsmall" style="font-size: 14px;">${adsJsp.con2}</p>

	<%--<h3></h3>--%>
	<%--<h3>${adsJsp.con2}</h3>--%>
</div>		
	<div id="vv" class="box effect8">
		<p class="mytext">${adsJsp.header}</p>
		<p class="mytextsmall">${adsJsp.con1}</p>
		<p class="mytextsmall">${adsJsp.con2}</p>
	</div>
	<div id="vv2" class="box effect8">
		<p class="mytext">${adsJsp.header}</p>
		<p class="mytextsmall">${adsJsp.con1}</p>
		<p class="mytextsmall">${adsJsp.con2}</p>
	</div>
	<div id="vv3" class="box effect8">
		<p class="mytext">${adsJsp.header}</p>
		<p class="mytextsmall">${adsJsp.con1}</p>
		<p class="mytextsmall">${adsJsp.con2}</p>
	</div>
	<div id="vv4" class="box effect8">
		<p class="mytext">${adsJsp.header}</p>
		<p class="mytextsmall">${adsJsp.con1}</p>
		<p class="mytextsmall">${adsJsp.con2}</p>
	</div>
	<div id="vv5" class="box effect8">
		<p class="mytext">${adsJsp.header}</p>
		<p class="mytextsmall">${adsJsp.con1}</p>
		<p class="mytextsmall">${adsJsp.con2}</p>
	</div>

<script>

	$('#vv').click(function () {
		$(this).hide(2000, function () {
			$(this).remove();
			$.get("/mail", {param : '${adsJsp.adname}', rating : '${adsJsp.rating}'}, function(responseText) {
				$('#rating_id').text(responseText);
			})
		});
	});
	$('#vv2').click(function () {
		$(this).hide(2000, function () {
			$(this).remove();
		});
	});
</script>

</body>
</html>