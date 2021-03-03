<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Logged</title>
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
	<c:choose>
		<c:when test="${logwarning ne null}">
			<p>
				<b>${logwarning}</b>
			</p>
		</c:when>
		<c:otherwise>
			<h1>Hello ${user.firstName}</h1>

		</c:otherwise>
	</c:choose>

	<form action="logout" method="get">
		<input type="submit" value="logout">
	</form>

	<p>
		Back <a href="index.html">Home</a>
	</p>
	<div id="footer">
		<a href="index.html">Home</a> | <a href="credit.jsp">Top-up</a>| <a
			href="update.jsp">Update Profile</a><br> Copyright © 2021 |
		Designed by Team Blue
	</div>

	<!-- end of footer -->
</body>
</html>