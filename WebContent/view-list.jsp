<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gamer lists</title>
</head>
<body>
<form method = "post" action = "listNavigationServlet">
<table>
	<c:forEach items="${requestScope.allLists}" var="currentlist">
		<tr>
			<td>
				<h2>
				<input type="radio" name="id" value="${currentlist.id}">
				${currentlist.listName}</h2>
			</td>
		</tr>
		<tr>
			<td>
			Gamer Name:	${currentlist.gamer.gamerName}
			<c:forEach var = "listVal" items = "${currentlist.listOfGames}">
				<tr>
					<td>Title: ${listVal.gameName}</td>
					<td>Genre: ${listVal.genre}</td>
					<td>Console: ${listVal.gameConsole}</td>
					<td>Publisher: ${listVal.publisher}</td>
					<td>Release Date: ${listVal.releaseDate}</td>
			 	</tr>
			</c:forEach>
		</td>
	</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToItem">
<input type = "submit" value = "delete" name="doThisToItem">
<input type="submit" value = "add list" name = "doThisToItem">
</form>
<a href="index.html">Add a game to the library</a>
</body>
</html>