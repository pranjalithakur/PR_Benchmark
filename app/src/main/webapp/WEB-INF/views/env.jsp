<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Environment</title>
</head>
<body>
	<h2>System Properties</h2>
	<table border="1">
		<tr><th>Name</th><th>Value</th></tr>
		<c:forEach var="entry" items="${env}">
			<tr>
				<td>${entry.key}</td>
				<td>${entry.value}</td>
			</tr>
		</c:forEach>
	</table>
	<p><a href="/admin">Back</a></p>
</body>
</html>
