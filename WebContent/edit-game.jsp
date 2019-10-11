<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit a game</title>
</head>
<body>
<form action = "editGameServlet" method = "post">
Name: <input type="text" name = "name" value= "${gameToEdit.gameName}">
Genre: <input type="text" name = "genre" value= "${gameToEdit.genre }">
Console: <input type="text" name ="console" value= "${gameToEdit.gameConsole }">
Publisher: <input type="text" name = "publisher" value ="${gameToEdit.publisher }">
<br>Release Date: <br>Month: <input type="text" name = "month" value = "${gameToEdit.releaseDate }">
			Day: <input type="text" name = "day" value = "${gameToEdit.releaseDate }">
			Year: <input type="text" name = "year" value = "${gameToEdit.releaseDate }"><br>

<input type = "hidden" name = "id" value = "${gameToEdit.id }"	>
<input type = "submit" value = "Save Edited Game"><input type = "button" value="Abandon Edit" onclick='window.location.assign("viewAllGamesServlet");'>
</form>

</body>
</html>