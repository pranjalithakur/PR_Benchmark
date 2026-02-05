<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>Uploads</title>
</head>
<body>
	<h2>Upload</h2>
	<p>${error}</p>
	<form method="post" action="/upload" enctype="multipart/form-data">
		<label>Directory</label><input type="text" name="dir" value="/tmp/uploads"/><br/>
		<label>File</label><input type="file" name="file"/><br/>
		<button type="submit">Upload</button>
	</form>
	<p>Uploaded: ${uploaded}</p>
	<p><a href="/files?path=/tmp/uploads">View file</a></p>
	<p><a href="/dashboard">Back</a></p>
</body>
</html>
