<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload</title>
</head>
<body>
	<form method="post" action="/FileUpload/fileupload" enctype="multipart/form-data">	<!-- post방식:get방식으로 파일을 주기에는 용량이 제한됨. enctype="multipart/form-data" -->
		FileName :
		<input type="text" name="title"><br>
		<input type="file" name="upfile"><br>
		<input type="submit" value="업로드">
	</form>
</body>
</html>