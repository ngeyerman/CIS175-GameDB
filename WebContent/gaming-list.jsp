<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Game List</title>
</head>
<body>
	<form method="post" action="navigationServlet">
		<table>
			<c:forEach items="${requestScope.allGames }" var="currentgame">
				<tr>

					<td><input type="radio" name="id" value="${currentgame.id}"></td>
					<td>${currentgame.gameName}</td>
					<td>${currentgame.genre}</td>
					<td>${currentgame.gameConsole}</td>
					<td>${currentgame.publisher}</td>
					<td>${currentgame.releaseDate }</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToItem"> 
		<input type="submit" value="delete" name="doThisToItem"> 
		<input type="submit" value="add" name="doThisToItem">
	</form>
</body>
</html>