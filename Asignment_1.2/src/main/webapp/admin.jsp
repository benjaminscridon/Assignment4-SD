<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Flights</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="resources/css/template.css">
<link rel="stylesheet" href="resources/css/header.css">
<link rel="stylesheet" href="resources/css/table.css">
<link rel="stylesheet" href="resources/css/footer.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-2.1.3.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<!-- HEADER -->
	<div class="header">
		<span class="glyphicon glyphicon-home icon"></span> <a
			class="glyphicon glyphicon-plus icon"></a> <a
			class="glyphicon glyphicon-search icon"></a> <a
			class="glyphicon glyphicon-user icon"></a> <a
			class="glyphicon glyphicon-volume-up icon"></a> <a
			class="glyphicon glyphicon-pencil icon"></a> <a
			class="glyphicon glyphicon-envelope icon"></a> <a
			class="glyphicon glyphicon-print icon"></a> <a
			class="glyphicon glyphicon-plane icon"></a> <a
			class="glyphicon glyphicon-lock icon"></a> <a
			class="glyphicon glyphicon-signal icon"></a> <a
			class="glyphicon glyphicon-star icon"></a> <a
			class="glyphicon glyphicon-cog icon"></a> <a
			class="glyphicon glyphicon-log-out icon"></a>
	</div>


	<c:if test="${error!=null}">
		<div class=" alert alert-danger fade in message">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>${error}</strong>
		</div>
	</c:if>

	<c:if test="${success!=null}">
		<div class="alert alert-success fade in">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>${success}</strong>
		</div>

	</c:if>
	


	<!-- TABLE WITTH ALL FLIGHTS -->

	<div class="col-sm-12">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Flight No</th>
					<th>Departure City</th>
					<th>Departure Date</th>
					<th>Arrival City</th>
					<th>Arrival Date</th>
					<th></th>
				</tr>
			</thead>

			<tbody>

				<c:forEach var="flight" items="${flights}">
					<tr>
						<td>${flight.flightNumber}</td>

						<td><a class="city-label" href="local-time?city=">${flight.departureCity.name}</a>
						</td>
						<td>&#128336; ${timeFormat.format(flight.departureDateTime)}
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &#128197;
							${dateFormat.format(flight.departureDateTime)}</td>

						<td><a class="city-label" href="local-time?city=" >${flight.arrivalCity.name}</a>
						</td>
						<td>&#128336; ${timeFormat.format(flight.arrivalDateTime)}
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &#128197;
							${dateFormat.format(flight.arrivalDateTime)}</td>


						<td>
							<form id="deleteForm${flight.id}" action="admin" method="POST">
								<input name="flightId" value="${flight.id}" type="hidden"/>
								<span class="glyphicon glyphicon-trash city-label"  onclick="document.getElementById('deleteForm${flight.id}').submit()"></span>
							</form>
						</td>
					
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


	<!-- FOOTER -->
	<footer class="container-fluid">
		<p>Copyright &#169; 2016 | Site built by Beniamin Scridon
			&#9992;&#9992; &#9992;</p>
	</footer>
</body>
</html>