<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Update Profile</title>
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
	<c:if test="${message_vehicle ne null}">
		<p>
			<b>${message_vehicle}</b>
		</p>
	</c:if>

	<c:if test="${message_vehicle_2 ne null}">
		<p>
			<b>${message_vehicle_2}</b>
		</p>
	</c:if>

	<h3>Change your vehicle type</h3>
	<form action="VehicleUpdate" method="get">
		<p>Select a vehicle type:</p>
		<div>
			<input type="radio" id="car" name="vehicle_id" value="1"> <label
				for="car">Car</label>
		</div>
		<div>
			<input type="radio" id="bike" name="vehicle_id" value="2"> <label
				for="bike">Bike</label>
		</div>
		<div>
			<input type="radio" id="camper" name="vehicle_id" value="3">
			<label for="camper">Camper</label>
		</div>
		<div>
			<input type="radio" id="electric_vehicle" name="vehicle_id" value="4">
			<label for="electric_vehicle">Electric Vehicle</label>
		</div>
		<input type="text" name="license_plate" id="license" maxlength="45"
			placeholder="License Plate ">
		<button type="submit">Invio</button>
		<button type="reset">Reset</button>
	</form>

	<div id="footer">
		<a href="index.html">Home</a> | <a href="credit.jsp">Top-up</a> | <a href="update.jsp.jsp">Update Profile</a><br>
		Copyright Â© 2021 | Designed by Team Blue
	</div>
	<!-- end of footer -->
</body>