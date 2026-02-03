<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Messages</title>
</head>
<body>
	<h2>Messages</h2>
	<p>${error}</p>
	<form method="post" action="/messages">
		<label>Recipient</label><input type="text" name="recipient"/><br/>
		<label>Message</label><textarea name="content"></textarea><br/>
		<button type="submit">Send</button>
	</form>
	<h3>Inbox for ${target}</h3>
	<table border="1">
		<tr><th>From</th><th>To</th><th>Message</th><th>Sent</th></tr>
		<c:forEach var="msg" items="${messages}">
			<tr>
				<td>${msg.sender}</td>
				<td>${msg.recipient}</td>
				<td>${msg.content}</td>
				<td>${msg.sentAt}</td>
			</tr>
		</c:forEach>
	</table>
	<p><a href="/dashboard">Back</a></p>
</body>
</html>
