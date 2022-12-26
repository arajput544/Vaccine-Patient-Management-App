<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"> 
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<html><head><title>Edit Entry</title></head><body>
<form action='EditEntry' method='post'>
<table class="table table-bordered table-striped table-dark">
<tr>
<td>Name:</td>
<td>
<input type='hidden' name='id' value= "${id}">
<input type='text' name='name' value= "${entry.name}">
</td>
</tr>
<tr>
<td>Doses Required:</td>
<td><select name='doses'><option value=1>1</option>
<option value=2>2</option>
</select>
<tr>
<td>Days Between Doses:</td>
<td><input type="text" name="daysBetweenDoses"></td>
</tr>
<tr><td colspan='2'><button>Save</button></td></tr></table>
</form>
</body>
</html>