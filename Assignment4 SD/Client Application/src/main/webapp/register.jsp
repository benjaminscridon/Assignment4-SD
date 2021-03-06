<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title></title>
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap-theme.min.css" />
<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
<script src="resources/js/bootstrap.min.js" type="text/javascript"></script>
<script src="resources/js/npm.js" type="text/javascript"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body >
	<nav class="navbar navbar-inverse">
  		<div class="container-fluid padd-20-rel" >
    		<div class="navbar-header">
      			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        		<span class="icon-bar"></span>
       			<span class="icon-bar"></span>
        		<span class="icon-bar"></span>
      			</button>
      			<a class="navbar-brand" href="#">PackageTracer</a>
    		</div>
    		<div class="collapse navbar-collapse" id="myNavbar"> 
      			<ul class="nav navbar-nav navbar-right">
        			<li><a href="register.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        			<li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      			</ul>
    		</div>
  		</div>
	</nav>
	<div class="login-content container">
		<div class="login-form col-md-6 col-md-offset-3 centered">
			<c:if test="${isErrorMessage}">
				<div class="alert alert-danger"><p><strong>Error!${errorMessage}</strong> </p></div>
			</c:if>
			
			<c:if test="${isSuccessMessage}">
				<div class="alert alert-success"><p><strong>${successMessage}</strong> </p></div>
			</c:if>
			
			<h3 class="center gray-bold"><strong>Register:</strong></h3><br/>
			<form  action="RegisterServlet" method="POST">
				<div class="row form-group"> 
					<label for="firstName" class="col-md-4 label-100"> First Name:</label> 
					<input class="col-md-7" type="text" name="firstName" id="firstName"> <br/>
				</div>
				<div class="row form-group"> 
					<label for="lastName" class="col-md-4 label-100"> Last Name:</label> 
					<input class="col-md-7" type="text" name="lastName" id="lastName"> <br/>
				</div>
				<div class="row form-group"> 
					<label for="email" class="col-md-4 label-100"> Email:</label> 
					<input class="col-md-7" type="text" name="email" id="email"> <br/>
				</div>
				<div class="row form-group">
					<label  for="password" class="col-md-4 label-100"> Password:</label>
					<input class="col-md-7" type="password" name="password" id="password"> <br/>
				</div>
				<div class="row form-group">
					<label  for="password2" class="col-md-4 label-100"> Repeat password:</label>
					<input class="col-md-7" type="password" name="password2" id="password2"> <br/>
				</div>
				<div class="row">
					<div  class="col-md-4"></div>
					<input  class="col-md-4 btn-md btn btn-info" type="submit" value="Register" name="registerSubmit"/>
					<div  class="col-md-4"></div>
				</div>
			</form>
			</div>
	</div>
	<div class="footer">
		<p>(C) Copyright 2016 PackageTracer </p>
	</div>
</body>
</html>