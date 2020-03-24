<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3> Tervetuloa väestorekisteriin</h3>
	<form action="VaestoServlet" method="post">
	
		<label>Syötä hetu: </label>
		<input type="text" name="hetu"><br><br>
		<input type="submit" value="Etsi">
	
	</form>
</body>
</html>