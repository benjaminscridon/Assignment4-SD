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
</head>

<body>

	<!-- HEADER -->
	<div class="header">
		<a class="glyphicon glyphicon-home icon"></a> <a
			class="glyphicon glyphicon-search icon"></a> <a
			class="glyphicon glyphicon-plus icon"></a> <a
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

	<!-- ADD NEW FLIGHT - FORM -->
	<div class="col-md-4"></div>

	<div class="col-md-4 form">
		<div>
			<h3 class="right-label">Add New Flight</h3>
		</div>

		<form action="add-flight" method="POST">
			<div class="form-group">
				<label class="control-label">Flight Number</label> <input
					type="text" class="form-control" name="flightNumber"
					id="flightNumber">
			</div>

			<div class="form-group">
				<label class="control-label">Airline Type</label> <input type="text"
					class="form-control" name="airplaneType" id="airplaneType">
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
					id="departureDateTime" value="2017-01-01T08:00">
			</div>

			<div class="form-group">
				<label class="control-label">Arrival City</label> 
				<select class="form-control" name="departureCity" id="departureCity">
					<c:forEach var="city" items="${cities}">
						<option value="${city.name}">${city.name}</>
					</c:forEach>
				</select>
			</div>

			<div class="form-group">
				<label class="control-label">Arrival Date and Time</label> <input
					class="form-control" type="datetime-local" value="2017-01-01T08:00"
					name="arrivalDateTime" id="arrivalDateTime">
			</div>

			<div class="form-group">
				<button class="btn btn-success " name="submit" type="submit">Add
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