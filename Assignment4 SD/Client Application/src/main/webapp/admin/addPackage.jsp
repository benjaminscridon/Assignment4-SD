<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<title></title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="../resources/js/bootstrap.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="../resources/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="../resources/css/bootstrap-theme.min.css" />
<link rel="stylesheet" type="text/css" href="../resources/css/style.css" />

</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid padd-20-rel">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="home">PackageTracer</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li class="padd-top-5">
						<form action="/ass4/logoutServlet" method="POST">
							<button type="submit" class="btn">
								<span class="glyphicon glyphicon-log-in"></span> Logout
							</button>
						</form>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="login-content container">
		<div class="login-form col-md-6 col-md-offset-3 centered">
			<c:if test="${isErrorMessage}">
				<div class="alert alert-danger">
					<p>
						<strong>Error!${errorMessage}</strong>
					</p>
				</div>
			</c:if>

			<c:if test="${isSuccessMessage}">
				<div class="alert alert-success">
					<p>
						<strong>${successMessage}</strong>
					</p>
				</div>
			</c:if>

			<h3 class="center gray-bold">
				<strong>Add new package:</strong>
			</h3>
			<br />
			<form action="addPackage" method="POST">
				<h4 class="center gray-bold">
					<strong>Sender:</strong>
				</h4>
				<div class="row form-group">
					<label for="firstName1" class="col-md-4 label-100"> First
						Name:</label> <input class="col-md-7" type="text" name="firstName1"
						id="firstName1"> <br />
				</div>
				<div class="row form-group">
					<label for="lastName1" class="col-md-4 label-100"> Last
						Name:</label> <input class="col-md-7" type="text" name="lastName1"
						id="lastName1"> <br />
				</div>
				<div class="row form-group">
					<label for="email1" class="col-md-4 label-100"> Email:</label> <input
						class="col-md-7" type="text" name="email1" id="email1"> <br />
				</div>

				<h4 class="center gray-bold">
					<strong>Receiver:</strong>
				</h4>
				<div class="row form-group">
					<label for="firstName2" class="col-md-4 label-100"> First
						Name:</label> <input class="col-md-7" type="text" name="firstName2"
						id="firstName2"> <br />
				</div>
				<div class="row form-group">
					<label for="lastName2" class="col-md-4 label-100"> Last
						Name:</label> <input class="col-md-7" type="text" name="lastName2"
						id="lastName2"> <br />
				</div>
				<div class="row form-group">
					<label for="email2" class="col-md-4 label-100"> Email:</label> <input
						class="col-md-7" type="text" name="email2" id="email2"> <br />
				</div>

				<h4 class="center gray-bold">
					<strong>Package:</strong>
				</h4>
				<div class="row form-group">
					<label for="name" class="col-md-4 label-100"> Name:</label> <input
						class="col-md-7" type="text" name="name" id="name"> <br />
				</div>
				<div class="row form-group">
					<label for="description" class="col-md-4 label-100">
						Description:</label>
					<textarea rows="3" class="col-md-7" name="description"
						id="description"> </textarea>
				</div>
				<div class="row form-group">
					<label for="senderCity" class="col-md-4 label-100"> Sender city:</label> <input
						class="col-md-7" type="text" name="senderCity" id="senderCity"> <br />
				</div>
				
				<div class="row form-group">
					<label for="destinationCity" class="col-md-4 label-100"> Destination city:</label> <input
						class="col-md-7" type="text" name="destinationCity" id="destinationCity"> <br />
				</div>

				<div class="row">
					<div class="col-md-4"></div>
					<input class="col-md-4 btn-md btn btn-info" type="submit"
						value="Add Package" name="addPackageButton" />
					<div class="col-md-4"></div>
				</div>
			</form>
		</div>
	</div>
	<div class="footer">
		<p>(C) Copyright 2016 PackageTracer</p>
	</div>
</body>
</html>