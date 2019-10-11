<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit a game</title>
</head>
<body>
<form action = "editGameServlet" method = "post">
<table>
<tr><td>Name: <input type="text" name = "name" value= "${gameToEdit.gameName}"></td></tr>
<tr><td>Genre: <input type="text" name = "genre" value= "${gameToEdit.genre }"></td></tr>
<tr><td>Console: <input type="text" name ="console" value= "${gameToEdit.gameConsole }"></td></tr>
<tr><td>Publisher: <input type="text" name = "publisher" value ="${gameToEdit.publisher }"></td></tr>

<c:set var="date" value="${fn:split(gameToEdit.releaseDate, '-')}" />
<tr><td>Release Date: <input type="text" name = "month" value="${date[1]}" placeholder="mm" size=2 maxlength=2>
			<input type="text" name = "day" value = "${date[2]}" placeholder="dd" size=2 maxlength=2>
			<input type="text" name = "year" value = "${date[0]}" placeholder="yyyy" size=4 maxlength=4></td></tr>
</table>
<input type = "hidden" name = "id" value = "${gameToEdit.id }"	>
<input type = "submit" value = "Save Edited Game"><input type = "button" value="Abandon Edit" onclick='window.location.assign("viewAllGamesServlet");'><br>
</form>
</body>
</html>