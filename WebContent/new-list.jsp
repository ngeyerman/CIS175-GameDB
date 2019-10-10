<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new list</title>
</head>
<body>
	<form action="createNewListServlet" method="post">
		List Name:<input type="text" name="listName"><br /> 
		Gamer Name: <input type="text" name="gamerName"><br /> 
		Available Games:<br /> <select name="allGamesToAdd" multiple size="6">
			<c:forEach items="${requestScope.allGames}" var="currentgame">
				<option value="${currentgame.id }">${currentgame.gameName}
					| ${currentgame.genre } | ${currentgame.gameConsole } |
					${currentgame.publisher } | ${currentgame.releaseDate }</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Create List and Add Games">
	</form>
	<a href="index.html">Go add a new game</a>
</body>
</html>