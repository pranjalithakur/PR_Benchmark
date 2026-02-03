<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>Dashboard</title>
</head>
<body>
	<h2>Dashboard</h2>
	<p>Hello ${user}</p>
	<p>Theme length: ${themeLen}</p>
	<ul>
		<li><a href="/tasks">Tasks</a></li>
		<li><a href="/messages">Messages</a></li>
		<li><a href="/profile">Profile</a></li>
		<li><a href="/tools">Tools</a></li>
		<li><a href="/reports">Reports</a></li>
		<li><a href="/upload">Uploads</a></li>
		<li><a href="/diagnostics">Diagnostics</a></li>
		<li><a href="/admin">Admin</a></li>
		<li><a href="/logout">Logout</a></li>
	</ul>
</body>
</html>
