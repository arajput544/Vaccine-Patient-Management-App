<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<html>
<head>
<title>Vaccination Application</title>
</head>
<body>
	<h2>Vaccination</h2>
	<span> <a href='NewVaccine'>New Vaccine</a> <a href='NewDose'>New
			Dose</a> <a href="ListPatient">Patients</a>
	</span>
	<table class="table table-bordered table-striped table-dark">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Vaccine</th>
				<th scope="col">Doses Required</th>
				<th scope="col">Days between doses</th>
				<th scope="col">Total Doses Recieved</th>
				<th scope="col">Total Doses Left</th>
				<th scope="col">&nbsp</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${entries}" var="entry">
				<tr>
					<td>${entry.getName()}</td>
					<td>${entry.dosesRequired}</td>
					<c:choose>
						<c:when test="${entry.daysBetweenDoses > 0}">
							<td>${entry.daysBetweenDoses}</td>
						</c:when>
						<c:otherwise>
							<td>&nbsp</td>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${entry.dosesReceived > 0}">
							<td>${entry.dosesReceived}</td>
						</c:when>
						<c:otherwise>
							<td>&nbsp</td>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${entry.totalDosesLeft > 0}">
							<td>${entry.totalDosesLeft}</td>
						</c:when>
						<c:otherwise>
							<td>&nbsp</td>
						</c:otherwise>
					</c:choose>
					<td><a href="EditEntry?id=${entry.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
