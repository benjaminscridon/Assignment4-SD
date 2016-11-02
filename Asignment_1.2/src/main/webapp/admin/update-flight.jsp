<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Flight</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="resources/css/template.css">
<link rel="stylesheet" href="resources/css/header.css">
<link rel="stylesheet" href="resources/css/footer.css">
<link rel="stylesheet" href="resources/css/add-flight.css">
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
		<span class="glyphicon glyphicon-home icon"></span> <span
			class="glyphicon glyphicon-search icon"></span> <span
			class="glyphicon glyphicon-plus icon"></span> <span
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
		<form id="logoutForm" action="logout" method="POST">
			<span class="glyphicon glyphicon-log-out icon"
				onclick="document.getElementById('logoutForm').submit()">
			</span>
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

	<!-- ADD NEW FLIGHT - FORM -->
	<div class="col-md-4"></div>

	<div class="col-md-4 form">
		<div>
			<h3 class="right-label">Update Flight</h3>
		</div>

		<form action="update-flight" method="POST">
			<div class="form-group">
				<label class="control-label">Flight Number</label> <input
					type="text" class="form-control" name="flightNumber"
					id="flightNumber" required="required" value="${flight.flightNumber}">
			</div>

			<div class="form-group">
				<label class="control-label">Airline Type</label> <input type="text"
					class="form-control" name="airplaneType" id="airplaneType"
					required="required" value="${flight.airplaneType}">
			</div>

			<div class="form-group">
				<label class="control-label">Departure City </label> <select
					class="form-control" name="departureCity" id="departureCity">
					<c:forEach var="city" items="${cities}">
						<option value="${city.name}">${city.name}</>
					</c:forEach>
				</select>
			</div>

			<div class="form-group">
				<label class="control-label">Departure Date and Time</label> <input
					class="form-control" type="datetime-local" name="departureDateTime"
					id="departureDateTime" value="2017-01-01T08:00" required="required">
			</div>

			<div class="form-group">
				<label class="control-label">Arrival City</label> <select
					class="form-control" name="arrivalCity" id="arrivalCity">
					<c:forEach var="city" items="${cities}">
						<option value="${city.name}">${city.name}</>
					</c:forEach>
				</select>
			</div>

			<div class="form-group">
				<label class="control-label">Arrival Date and Time</label> <input
					class="form-control" type="datetime-local" value="2017-01-01T08:00"
					name="arrivalDateTime" id="arrivalDateTime" required="required">
			</div>

			<div class="form-group">
				<button class="btn btn-success " name="submit" type="submit">Update
					Flight</button>
			</div>
		</form>
	</div>

	<!-- FOOTER -->
	<footer class="container-fluid">
		<p>Copyright &#169; 2016 | Site built by Beniamin Scridon
			&#9992;&#9992; &#9992;</p>
	</footer>
</body>
</html>