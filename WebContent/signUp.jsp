<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign Up</title>
</head>
<body  style="text-align:center" >
<!-- page where a user can register. -->
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
	        <h1>Sign Up</h1>
			<br>
			<br>
			<form action="signUp" method="post">
				<strong>Enter Email : </strong>
				<input type="text" name="email" placeholder="user@example.com" size=25 />
				<br>
				<br>
				<strong>Enter password : </strong>
				<input type="password" name="password" />
				<br>
				<br>
				<strong>Confirm password : </strong>
				<input type="password" name="confirmPassword" />
				<br>
				<p style="color:red;">${emailError}</p>
				<p style="color:red;">${passwordError}</p>
				<c:if test="${not empty alreadyRegistered}">
					<p style="color:red;">
						User registered already,please 
						<a href="logIn.jsp">log in</a>
					</p>
				</c:if>
				<input type="submit" name="signedUp" value="sign up"/>
			</form>
	    </c:otherwise>
	</c:choose>
</body>
</html>