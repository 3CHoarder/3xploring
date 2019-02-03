<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

	<!-- Access the bootstrap Css like this, 
		Spring boot will handle the resource mapping automcatically -->
<!-- 	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" /> -->

	<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<c:url value="/js/ghuserevents.js" var="jstlJS" />
	<script src="${jstlJS}"></script>

</head>
<body>
	<div class="container">
		<div class="starter-template">
			<h1>Spring Boot Web Example</h1>
			<h2>${message}</h2>
		</div>
	</div>
	
    GitHub User: <input type = "text" id = "user">
    <br />
    <button onclick = "doFunction()">Get Events</button>
	
	<br/><br/>
	<p><h2 id="show_user"></h2></p>
	
	<table id="excelDataTable" border="1" width="33%">
	
	</table>

</body>

</html>