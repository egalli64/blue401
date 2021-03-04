<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Update Profile</title>
<meta name="author" content="Team Blue">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="WebApp Parking">
<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="aw.css">
</head>
<div id="menu">

	<ul>
		<li><a href="index.jsp">HOME</a></li>
		<li><a href="credit.jsp">Top-up</a></li>
		<li><a href="update.jsp">Update Profile</a></li>
		<li><a href="logged.jsp">MyProfile</a></li>
	</ul>
	<br>
</div>
<div id="pagina"></div>
<body>
	<div class="bs-example">
		<h4>Your Profile</h4>
		<br>
		<table class="table table-striped table-dark">
		<thead>
		<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
		</tr>
		</thead>
		<tbody>
		<tr>
		<td>${user.firstName}</td>
		<td>${user.lastName}</td>
		<td>${user.eMail}</td>
		</tr>
		</tbody>
		</table>
		</div>


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
	<form action="update" method="get">
		<p>Select a vehicle type:</p>
		<div>
			<input type="radio" id="car" name="vehicle_id" value="1"> <label
				for="car">Car</label>
		</div>
		<div>
			<input type="radio" id="bike" name="vehicle_id" value="2"> <label
				for="bike">MotorBike</label>
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
		<button type="submit">Confirm</button>
		<button type="reset">Reset</button>
	</form>

	<div id="footer">
		<a href="index.jsp">Home</a> | <a href="credit.jsp">Top-up</a> | <a
			href="update.jsp">Update Profile</a> |<a href="logged.jsp">MyProfile</a>  <br> Copyright © 2021 |
		Designed by Blue Team
	</div>
</body>