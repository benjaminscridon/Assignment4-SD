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
				<a class="navbar-brand" href="#">PackageTracer</a>
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
		<div class="text-center login-form col-md-8 col-md-offset-2 centered">
			<h4 class="center gray-bold">
				<strong>Search package by AWB or by Name:</strong>
			</h4>

			<form class="text-center form-inline global-search" role="form">
				<div class="form-group center-block">
					<label class="sr-only" for="">Enter name or AWB</label> <input
						type="search" class="form-control" id="idOrName" name="idOrName"
						placeholder="Enter name or AWB">
				</div>
				<button type="submit" id="s" class="btn btn-default">
					<span class="glyphicon glyphicon-search"></span>
				</button>

			</form>
			<c:if test="${search}">
				<h3>Results for: ${searchText}</h3>
			</c:if>
			<h3 class="center gray-bold">
				<strong>Received packages:</strong>
			</h3>
			<hr/>

			<ul class="list-group">

				<c:forEach items="${receivedPackages}" var="pkg">
					<li style="list-style: none;">
						<div>
							<c:choose>
								<c:when test="${pkg.tacking}">
									<h2 class="center gray-bold">
									<a href="userPackageServlet?id=${pkg.id}"><strong>${pkg.name}</strong></a>
								</h2>
								</c:when>
								<c:otherwise>
									<h2 class="center gray-bold">
									<strong>${pkg.name}</strong>
								</h2>
								<p>Tracking unavailable</p>
								</c:otherwise>
							</c:choose>


							<h3>Description: ${pkg.description}</h3>
							<h3>
								<span>Route: ${pkg.senderCity} </span> <span
									class="glyphicon glyphicon-arrow-right">
									${pkg.destinationCity}</span>
							</h3>
						</div>
						<hr/>
					</li>
				</c:forEach>
			</ul>

			<h3 class="center gray-bold">
				<strong>Sent packages:</strong>
			</h3>
			<hr/>
			<ul class="list-group">
				<c:forEach items="${sentPackages}" var="spkg">
					<li style="list-style: none;">
						<div>
							<h2 class="center gray-bold">
								<a href="userPackageServlet?id=${spkg.id}"><strong>${spkg.name}</strong></a>
							</h2>
							<h3>Description: ${spkg.description}</h3>
							<h3>
								<span>Route: ${spkg.senderCity} </span> <span
									class="glyphicon glyphicon-arrow-right">
									${spkg.destinationCity}</span>
							</h3>
						</div>
						<hr/>
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