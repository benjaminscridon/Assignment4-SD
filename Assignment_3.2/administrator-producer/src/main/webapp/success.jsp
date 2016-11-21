<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Administrator</title>
	<link rel="stylesheet" href="css/style.css">
</head>

<body>
	
	<div class="box">
		
		<div id="header">
			<h1>'${dvd.title}' DVD sent out to all subscribers.</h1>
		</div>

		<form>
			<div class="group">
				<input class="inputMaterial" type="text" name="title" id="title"
					  value="${dvd.title}" > <span class="highlight"></span> <span
					class="bar"></span> <label>Title</label>
			</div>

			<div class="group">
				<input class="inputMaterial" type="text" name="year" id="year"
					 value="${dvd.year}"> <span class="highlight"></span> <span
					class="bar"></span> <label>Release Year</label>
			</div>

			<div class="group">
				<input class="inputMaterial" type="text" name="price" id="price"
					 value="${dvd.price}"> <span class="highlight"></span> <span
					class="bar"></span> <label>Price ($)</label>
			</div>
			
		</form>
	</div>

</body>
</html>