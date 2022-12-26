
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

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Patient</title>
</head>
<body>
	
	
	<h2>PATIENTS</h2>
	<a href="AddPatient">New Patient</a>
	<a href="Vaccination">Vaccination</a>
	<table class="table table-bordered table-striped table-dark">
		<thead class="thead-dark">
			<tr>
				<th scope="col">ID</th>
				<th scope="col">NAME</th>
				<th scope="col">VACCINE</th>
				<th scope="col">1ST DOSE</th>
				<th scope="col">2ND DOSE</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pList}" var="patient">
				<tr>
					<td>${patient.id}</td>
					<td>${patient.name}</td>
					<form action='ListPatient' method='post'>
					<td><input type="hidden" name="vaccinename" value='${patient.vaccine.getName()}'>${patient.vaccine.getName()}</td>
					<td>${patient.date1}</td>
					<td><c:choose>
							<c:when test="${empty patient.getDate2()}">
								<c:choose> 	
									<c:when test="${patient.getVaccine().getDosesRequired() == '1'}">
										-
									</c:when>
									<c:otherwise>
										<c:choose>
										<c:when test="${patient.getVaccine().getTotalDosesLeft() == '0' }">
										OUT OF STOCK										
										</c:when>
										<c:otherwise>
										
										<button class="btn btn-primary">Receive</button>
										
										<input type="hidden" name="id" value="${patient.id}">							
										</form>
										</c:otherwise>   
										</c:choose>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
							${patient.date2 }
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>


		</tbody>
	</table>
	
</body>
</html>