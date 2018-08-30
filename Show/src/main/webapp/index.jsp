<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

	<!-- Access the bootstrap Css like this, 
		Spring boot will handle the resource mapping automcatically -->
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

	<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />
<title>Adding New Vehicles:</title>
</head>
<body>

	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/Show/vehicles">ShowRoom</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/Show/scooters">Scooters</a></li>
      <li><a href="/Show/bikes">Bikes</a></li>
      <li><a href="/Show/cars">Cars</a></li>
    </ul>
  </div>
</nav>

	<div class="container">
		
    <h1>Available Vehicles in Showroom</h1>
   
    <br/><br/>
    <div>
      <table class="table">
  <thead>
        <tr>
          <th>Vehicle Name</th>
          <th>Low Price</th>
          <th>High Price</th>
        </tr>
        </thead>
  <tbody>
        <c:forEach  items="${vehicles}" var ="vehicle">
        <tr>
          <td>${vehicle.getName()}</td>
          <td>${vehicle.getMinprice()}</td>
          <td>${vehicle.getMaxprice()}</td>
        </tr>
        </c:forEach>
       </tbody>
</table>
    </div>
		</div>

</body>
</html>