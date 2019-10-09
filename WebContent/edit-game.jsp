<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "editGameServlet" method = "post">
Name: <input type="text" name = "name" value= "${gameToEdit.gameName}">
Genre: <input type="text" name = "genre" value= "${gameToEdit.genre }">
Console: <input type="text" name ="console" value= "${gameToEdit.gameConsole }">
Publisher: <input type="text" name = "publisher" value ="${gameToEdit.publisher }">
Date: <input type="text" name = "date" value = "${gameToEDit.date }">

<input type = "hidden" name = "id" value = "${gameToEdit.id }"	>
<input type = "submit" value = "Save Edited Game">
</form>

</body>
</html>