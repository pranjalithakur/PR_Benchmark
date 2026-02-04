<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>Diagnostics</title>
</head>
<body>
	<h2>Diagnostics</h2>
	<p>${error}</p>
	<form method="post" action="/diagnostics/memory">
		<label>Size</label><input type="text" name="size"/><br/>
		<label>Length</label><input type="text" name="length"/><br/>
		<label>Offset</label><input type="text" name="offset"/><br/>
		<label>Bytes</label><input type="text" name="bytes"/><br/>
		<button type="submit">Run</button>
	</form>
	<p>Bytes: ${memoryBytes}</p>
	<p>Value: ${memoryValue}</p>
	<p>After free: ${afterFree}</p>
	<p>Stack sample: ${stackSample}</p>
	<p><a href="/dashboard">Back</a></p>
</body>
</html>
