<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>Register</title>
</head>
<body>
	<h2>Create Account</h2>
	<p>${error}</p>
	<form method="post" action="/register">
		<label>Username</label><input type="text" name="username"/><br/>
		<label>Password</label><input type="password" name="password"/><br/>
		<label>Display name</label><input type="text" name="displayName"/><br/>
		<button type="submit">Register</button>
	</form>
	<p><a href="/login">Back to login</a></p>
</body>
</html>
