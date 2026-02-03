<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>Tools</title>
</head>
<body>
	<h2>Tools</h2>
	<p>${error}</p>
	<h3>Execute</h3>
	<form method="post" action="/tools/exec">
		<label>Command</label><input type="text" name="command"/><br/>
		<button type="submit">Run</button>
	</form>
	<h3>Scan</h3>
	<form method="post" action="/tools/scan">
		<label>Host</label><input type="text" name="host"/><br/>
		<label>Args</label><input type="text" name="args"/><br/>
		<button type="submit">Ping</button>
	</form>
	<h3>Buffer</h3>
	<form method="post" action="/tools/buffer">
		<label>Size</label><input type="text" name="size"/><br/>
		<label>Offset</label><input type="text" name="offset"/><br/>
		<label>Value</label><input type="text" name="value"/><br/>
		<button type="submit">Write</button>
	</form>
	<h3>Grow</h3>
	<form method="post" action="/tools/grow">
		<label>Count</label><input type="text" name="count"/><br/>
		<button type="submit">Allocate</button>
	</form>
	<pre>${output}</pre>
	<p>Buffer value: ${bufferValue}</p>
	<p>Allocations: ${allocations}</p>
	<p><a href="/dashboard">Back</a></p>
</body>
</html>
