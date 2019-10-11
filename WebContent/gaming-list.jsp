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
					<td>Title: ${currentgame.gameName}</td>
					<td>Genre: ${currentgame.genre}</td>
					<td>Console: ${currentgame.gameConsole}</td>
					<td>Publisher: ${currentgame.publisher}</td>
					<td>Release Date: ${currentgame.releaseDate }</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToItem"> 
		<input type="submit" value="delete" name="doThisToItem"> 
		<input type="submit" value="add" name="doThisToItem"><br>
		<a href ="viewAllListsServlet">View all game lists</a><br>
		<a href ="addGamesForListServlet">Create a new game list</a>
	</form>
</body>
</html>