<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>Reports</title>
</head>
<body>
	<h2>Reports</h2>
	<p>${error}</p>
	<form method="post" action="/reports/run">
		<label>Expression</label><input type="text" name="expression" size="60"/><br/>
		<button type="submit">Run</button>
	</form>
	<p>Result: ${reportResult}</p>
	<form method="post" action="/reports/fetch">
		<label>Fetch URL</label><input type="text" name="url" size="60"/><br/>
		<button type="submit">Fetch</button>
	</form>
	<pre>${fetchResult}</pre>
	<p><a href="/dashboard">Back</a></p>
</body>
</html>
