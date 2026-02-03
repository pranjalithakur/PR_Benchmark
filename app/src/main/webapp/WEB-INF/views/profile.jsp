<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>Profile</title>
</head>
<body>
	<h2>Profile</h2>
	<p>${error}</p>
	<p>User: ${username}</p>
	<p>Display: ${displayName}</p>
	<p>Role: ${role}</p>
	<p>Password: ${password}</p>
	<form method="post" action="/profile/update">
		<label>User</label><input type="text" name="user" value="${username}"/><br/>
		<label>Display name</label><input type="text" name="displayName"/><br/>
		<button type="submit">Update</button>
	</form>
	<p><a href="/dashboard">Back</a></p>
</body>
</html>
