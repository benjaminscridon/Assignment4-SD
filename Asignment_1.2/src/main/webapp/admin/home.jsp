<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Flights</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="../resources/css/template.css">
<link rel="stylesheet" href="../resources/css/header.css">
<link rel="stylesheet" href="../resources/css/table.css">
<link rel="stylesheet" href="../resources/css/footer.css">
<link rel="stylesheet" href="../resources/css/add-flight.css">
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

		<a class="glyphicon glyphicon-home icon" href="/airline/admin/home"></a> <span
			class="glyphicon glyphicon-search icon"></span> 
			
			<a
			class="glyphicon glyphicon-plus icon" href="/airline/admin/add-flight"></a> <span
			class="glyphicon glyphicon-user icon"></span> <span
			class="glyphicon glyphicon-volume-up icon"></span> <span
			class="glyphicon glyphicon-pencil icon"></span> <span
			class="glyphicon glyphicon-envelope icon"></span> <span
			class="glyphicon glyphicon-print icon"></span> <span
			class="glyphicon glyphicon-plane icon"></span> <span
			class="glyphicon glyphicon-lock icon"></span> <span
			class="glyphicon glyphicon-signal icon"></span> <span
			class="glyphicon glyphicon-star icon"></span> <span
			class="glyphicon glyphicon-cog icon"></span>

		<form id="logoutForm" action="../logout" method="POST"
			class="logout-form">
			<span class="glyphicon glyphicon-log-out icon"
				onclick="document.getElementById('logoutForm').submit()"></span>
		</form>
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
					<th></th>
				</tr>
			</thead>

			<tbody>

				<c:forEach var="flight" items="${flights}">
					<tr>
						<td>${flight.flightNumber}</td>

						<td><span class="city-label">${flight.departureCity.name}</span>
						</td>
						<td>&#128336; ${timeFormat.format(flight.departureDateTime)}
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &#128197;
							${dateFormat.format(flight.departureDateTime)}</td>

						<td><span class="city-label">${flight.arrivalCity.name}</span>
						</td>
						<td>&#128336; ${timeFormat.format(flight.arrivalDateTime)}
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &#128197;
							${dateFormat.format(flight.arrivalDateTime)}</td>


						<td>
							<form id="editForm${flight.id}" action="update-flight"
								method="GET">
								<input name="flightId-update" value="${flight.id}" type="hidden" />
								<span class="glyphicon glyphicon-edit city-label"
									onclick="document.getElementById('editForm${flight.id}').submit()"></span>
							</form>
						</td>


						<td>
							<form id="deleteForm${flight.id}" action="home" method="POST">
								<input name="flightId" value="${flight.id}" type="hidden" /> <span
									class="glyphicon glyphicon-trash city-label"
									onclick="document.getElementById('deleteForm${flight.id}').submit()"></span>
							</form>
						</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<footer class="container-fluid">
		<p>Copyright &#169; 2016 | Site built by Beniamin Scridon
			&#9992;&#9992; &#9992;</p>
	</footer>
</body>
</html>