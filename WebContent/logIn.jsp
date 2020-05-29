<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>log In</title>
</head>
<body  style="text-align:center" >
	<c:choose>
	    <c:when test="${not empty userEmail}">
	    	<br>
	    	<h4 style="color:red;">User logged In already.</h4>
	    	<h4 style="color:red;">
	    		go to : 
	    		<a href="homePage.jsp">home page</a>
	    	</h4>
	    </c:when>
	    <c:otherwise>
			<h1>log In</h1>
			<br>
			<br>
			<form action="logIn" method="post">
				<strong>Enter Email : </strong>
				<input type="text" name="email" placeholder="user@example.com" size=25 />
				<br>
				<br>
				<strong>Enter password : </strong>
				<input type="password" name="password" />
				<br>
				<br>
				<c:if test="${not empty emailError}">
					<p style="color:red;">${emailError}</p>
				</c:if>
				<c:if test="${not empty passwordError}">
					<p style="color:red;">${passwordError}</p>
				</c:if>
				<c:if test="${not empty registerError}">
					<p style="color:red;">
						${registerError}
						<br>
						please <a href="signUp.jsp">register</a>
					</p>
				</c:if>
				<input type="submit" name="signedUp" value="sign in"/>
			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>