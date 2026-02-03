<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Tasks</title>
</head>
<body>
	<h2>Tasks</h2>
	<p>${error}</p>
	<form method="post" action="/tasks">
		<label>Owner</label><input type="text" name="owner" value="${owner}"/><br/>
		<label>Title</label><input type="text" name="title"/><br/>
		<label>Details</label><textarea name="details"></textarea><br/>
		<button type="submit">Add Task</button>
	</form>
	<h3>Task list for ${owner}</h3>
	<table border="1">
		<tr><th>Id</th><th>Owner</th><th>Title</th><th>Details</th><th>Created</th></tr>
		<c:forEach var="task" items="${tasks}">
			<tr>
				<td>${task.id}</td>
				<td>${task.owner}</td>
				<td>${task.title}</td>
				<td>${task.details}</td>
				<td>${task.createdAt}</td>
			</tr>
		</c:forEach>
	</table>
	<p><a href="/dashboard">Back</a></p>
</body>
</html>
