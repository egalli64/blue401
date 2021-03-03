<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Credit update</title>
<meta name="author" content="Team Blue">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="aw.css">
<meta name="keywords" content="WebApp Parking">
</head>
<div id="menu">
	<ul>
		<li><a href="index.html">HOME</a></li>
		<li><a href="credit.jsp">Top-up</a></li>
		<li><a href="update.jsp">Update Profile</a></li>
	</ul>
</div>
<div id="pagina"></div>
<body>
	<h1>My credit area</h1>
	<form action="credit" method="post">
		<input type="submit" value="Your credit">
		<p>Credit: ${current} €</p>
	</form>
	<form action="credit" method="get">
		<label>Quanto vuoi ricaricare?</label>
		<div>
			<input type="radio" id="5" name="money" value="5"> <label
				for="5">5€</label>
		</div>
		<div>
			<input type="radio" id="10" name="money" value="10"> <label
				for="10">10€</label>
		</div>
		<div>
			<input type="radio" id="25" name="money" value="25"> <label
				for="25">25€</label>
		</div>
		<div>
			<input type="radio" id="50" name="money" value="50"> <label
				for="50">50€</label>
		</div>


		<div>
			<button type="submit">Invio</button>
			<button type="reset">Reset</button>
		</div>
	</form>
	<c:if test="${message ne null}">
		<p>
			<b>${message}</b>
		</p>
	</c:if>
	<c:if test="${message_2 ne null}">
		<p>
			<b>${message_2}</b>
		</p>
	</c:if>
	<div id="footer">
		<a href="index.html">Home</a> | <a href="credit.jsp">Top-up</a> | <a
			href="update.jsp.jsp">Update Profile</a><br> Copyright Â© 2021 |
		Designed by Team Blue
	</div>
	<!-- end of footer -->
</body>