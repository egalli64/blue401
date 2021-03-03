<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>

<title>Home Page</title>

<meta name="author" content="Team Blue">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="aw.css">
<meta name="keywords" content="WebApp Parking">

</head>
<h1>WELCOME</h1>

<div id="menu">
	<ul>
		<li><a href="index.html">HOME</a></li>
	</ul>
</div>
<div id="pagina"></div>
<body>
	<div id="contenitore">
		<h3>Log in</h3>
		<form action="login" method="post">
			<input name="username" placeholder="email "> <input
				type="password" name="password" placeholder="password">
			<button>Invio</button>	
		</form>
		<c:if test="${logwarning ne null}">
			<p>
				<b>${logwarning}</b>
			</p>
		    </c:if>
		<h3>If you are not registered, create new account:</h3>
		<form action="registuser" method="get">
			<table>
				<thead>
					<tr>
						<th scope="row"></th>
						<th scope="col">Your profile:</th>

					</tr>
				</thead>
				<tr>
					<th scope="row"><label for="user">First Name:</label></th>
					<td><input type="text" id="user" name="user" maxlength="45"></td>


				</tr>
				<tr>
					<th scope="row"><label for="userlast">Last name:</label></th>
					<td><input type="text" id="userlast" name="userlast"
						maxlength="45"></td>

				</tr>
				<tr>
					<th scope="row"><label for="pass">Password:</label></th>
					<td><input type="password" id="pass" name="pass"
						maxlength="50"></td>

				</tr>
				<tr>
					<th scope="row"><label for="data">Date of birth:</label></th>
					<td><input type="date" id="data" name="data" maxlength="10"></td>

				</tr>
				<tr>
					<th scope="row"><label for="mail">email:</label></th>
					<td><input type="email" id="mail" name="mail" maxlength="45"></td>

				</tr>
				<tr>
					<th scope="row"><label for="license">License Plate:</label></th>
					<td><input type="text" id="license" name="license"
						maxlength="45"></td>

				</tr>


			</table>

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
				<input type="radio" id="electric_vehicle" name="vehicle_id"
					value="4"> <label for="electric_vehicle">Electric
					Vehicle</label>
			</div>


			<div>
				<button type="submit">Invio</button>
				<button type="reset">Reset</button>
			</div>
			<html>

		</form>

		<div id="footer">
			<a href="index.html">Home</a><br> Copyright Â© 2021 | Designed
			by Team Blue
		</div>
		<!-- end of footer -->
	</div>
</body>