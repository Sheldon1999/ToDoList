<!-- import jstl library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

	<title>my to-do list</title>

</head>

<body>
<!-- form to add items in list -->
<!-- send value to addItem servlet using post method -->
<form action="addItems" method="post">
	Add item : <input type="text" name="theItem" placeholder="enter item here to add" size="50" />
	<input type="submit" name="addTheItem" value="add item">
</form>

	<br>
	<!-- listing items here -->
	<h2>your Items : </h2>
	<hr>
	<ul>
		<c:forEach var="tempItem" items="${listItems}">
			<li>${tempItem}</li>
		</c:forEach>
	</ul>
</body>

</html>