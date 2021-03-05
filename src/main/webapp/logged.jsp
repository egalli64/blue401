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
		<!-- <li><a href="index.jsp">HOME</a></li> -->
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

			<h2>Choose your parking to get more information! :)</h2>
			<br>

			<div class="grid-container">
				<div class="grid-item">
					<div id="box1">
						<a href="parking1"> <iframe
								src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15718.198901288937!2d7.633255701223295!3d45.04467293408329!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47886cd518833c99%3A0xbf32e26c4a1fea49!2sSanta%20Rita%2C%20Torino%20TO!5e0!3m2!1sit!2sit!4v1614782947253!5m2!1sit!2sit"
								width="300" height="225" style="border: 0;"> </iframe>More info
							->
						</a>
						<p>
							<b>Parking Name: ${parking1.parkingName}</b>
						</p>
						<p>
							<b>Tariff: ${parking1.cost} €/hr </b>
						</p>
						<p>
							<b>Parking capacity: ${parking1.capacity}</b>
						</p>
						<br> <a href="park1"><button>Park Here</button></a>
					</div>
				</div>
				<div class="grid-item">
					<div id="box2">
						<a href="parking2"> <iframe
								src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d10952.416507460957!2d7.662219730783046!3d45.05868203694756!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47886d3c52995927%3A0xfe146208a52f439b!2sCrocetta%2C%20Torino%20TO!5e0!3m2!1sit!2sit!4v1614783008571!5m2!1sit!2sit"
								width="300" height="225" style="border: 0;"></iframe>More info
							->
						</a>
						<p>
							<b>Parking Name: ${parking2.parkingName}</b>
						</p>
						<p>
							<b>Tariff: ${parking2.cost} €/hr </b>
						</p>
						<p>
							<b>Parking capacity: ${parking2.capacity}</b>
						</p>
						<br> <a href="park2"><button>Park Here</button></a>
					</div>
				</div>
				<div class="grid-item">
					<div id="box3">
						<a href="parking3"> <iframe
								src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d20523.709110909!2d7.670412183300883!3d45.06690809018204!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47886d0f91f62815%3A0xcbe3013012f65e68!2sTorino%20Porta%20Susa!5e0!3m2!1sit!2sit!4v1614849020959!5m2!1sit!2sit"
								width="300" height="225" style="border: 0;"></iframe>More info
							->
						</a>
						<p>
							<b>Parking Name: ${parking3.parkingName}</b>
						</p>
						<p>
							<b>Tariff: ${parking3.cost} €/hr </b>
						</p>
						<p>
							<b>Parking capacity: ${parking3.capacity}</b>
						</p>
						<br> <a href="park3"><button>Park Here</button></a>
					</div>
				</div>


			</div>



			<br>
			<br>


		</c:otherwise>
	</c:choose>

	<c:if test="${logwarning eq null}">
		<form action="logout" method="get">
			<input type="submit" value="logout">
		</form>
	</c:if>

	<p>
		Back <a href="index.jsp">Home</a>
	</p>
	<div id="footer">
		<!-- <a href="index.jsp">Home</a>  -->| <a href="credit.jsp">Top-up</a>| <a
			href="show">Update Profile</a> | Copyright © 2021 | Designed by Team
		Blue
	</div>
	<!-- end of footer -->
</body>
</html>