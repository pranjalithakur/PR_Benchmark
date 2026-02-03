<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>Login</title>
</head>
<body>
	<h2>Welcome</h2>
	<p>${error}</p>
	<form method="post" action="/login">
		<label>Username</label><input type="text" name="username"/><br/>
		<label>Password</label><input type="password" name="password"/><br/>
		<label>Remember me</label><input type="checkbox" name="remember" value="1"/><br/>
		<label>Session Id</label><input type="text" name="sid"/><br/>
		<button type="submit">Sign in</button>
	</form>
	<p><a href="/register">Create account</a></p>
</body>
</html>
