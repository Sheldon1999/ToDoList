<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>
</head>
<body style="text-align:center" >
	<br>
	<h1> Welcome </h1>
	<h1> To </h1>
	<h1> To-Do-List</h1>
	<h4> web-utility </h4>
	<h6> please login or register :</h6>
	<div>
		<form action="logIn.jsp" method="post">
			<input style="border:2px solid black;" type="submit" value="log in" />
		</form>
		<br>
		<form action="signUp.jsp" method="post">
			<input style="border:2px solid black;" type="submit" value="sign up"/>
		</form>
	</div>
	<br>
	<br>
	<h3> About us </h3>
	<hr style="width:40%" >
	<p> Author : Ankur Gangwar </p>
	<p> Front End : HTML and CSS </p>
	<p> Back End : JSP and Servlet </p>
	<p> Database : MySQL </p>
	<p> Server : Apache Tomcat </p>
</body>
</html>