<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<title></title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap-theme.min.css" />
<link rel="stylesheet" type="text/css" href="resources/css/style.css" />

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
				<a class="navbar-brand" href="user">PackageTracer</a>
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
		<div class="login-form col-md-8 col-md-offset-2 centered">
			<h3><a href="/ass4/user"> <span
				class="glyphicon glyphicon-menu-left"></span> Back
			</a></h3>
			<h3 class="text-center">${packagee.name}</h3>
			<h4>Description: ${packagee.description}</h4>
			<h4>Route: ${packagee.senderCity} to ${packagee.destinationCity}</h4>
			<h4>From: ${packagee.sender.firstName}
				${packagee.sender.lastName} to ${packagee.receiver.firstName}
				${packagee.receiver.lastName}</h4>
			<h4>Route:</h4>
			<ul class="list-group">
				<c:forEach items="${routee}" var="r">
					<li style="list-style: none;">
						<div>
							<h5>${r}</h5>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="footer">
		<p>(C) Copyright 2016 PackageTracer</p>
	</div>
</body>
</html>