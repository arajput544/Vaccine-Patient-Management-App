<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"> 
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<html><head><title>New Dose</title></head><body>
<form action='NewDose' method='post'>
<table class="table table-bordered table-striped table-dark">
<tbody>
<tr>
<td>Vaccine:</td>
<td>
<select name='VaccineDropDown'>
<c:forEach items="${entries}" var="entry">
<option>${entry.name}</option>
</c:forEach>
</select>
</td>
</tr>
<tr><td>New Doses Received</td>
<td><input type='text' name='dosesReceived'></td>
</tr>
<tr><td colspan='2'><button>Add</button></td></tr>
</tbody>
</table>
</form>
</body>
</html>

