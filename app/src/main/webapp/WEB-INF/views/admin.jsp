<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>Admin</title>
</head>
<body>
	<h2>Admin Console</h2>
	<p>Role: ${role}</p>
	<p>${error}</p>
	<form method="post" action="/admin/promote">
		<label>Username</label><input type="text" name="username"/><br/>
		<label>Role</label><input type="text" name="role"/><br/>
		<label>Actor</label><input type="text" name="actor"/><br/>
		<button type="submit">Promote</button>
	</form>
	<form method="post" action="/admin/import">
		<label>Import payload (base64)</label><br/>
		<textarea name="payload" rows="5" cols="60"></textarea><br/>
		<button type="submit">Import</button>
	</form>
	<p>Import result: ${importResult}</p>
	<p><a href="/admin/env">View env</a></p>
	<p><a href="/dashboard">Back</a></p>
</body>
</html>
