package com.toDoList;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class signUp
 */
@WebServlet("/signUp")
public class signUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		email = email.toLowerCase();
		
		String password = request.getParameter("password");
		
		String confirmPass = request.getParameter("confirmPassword");
		
		boolean isError = false;
		String error = null;
		
		if(password.length() == 0 || password == null){
			error = "password can not be null";
			request.setAttribute("passwordError",error);
			isError = true;
		}
		else if(confirmPass.length() == 0 || confirmPass == null){
			error = "confirm password can not be null";
			request.setAttribute("passwordError",error);
			isError = true;
		}
		else if(!password.equals(confirmPass)){
			error = "both passwords must be same";
			request.setAttribute("passwordError",error);
			isError = true;
		}
		if(email.length() == 0 || email == null){
			error = "email can not be null";
			request.setAttribute("emailError",error);
			isError = true;
		}
		else if(!emailValidator.isValidEmail(email)){
			error = "enter correct email";
			request.setAttribute("emailError",error);
			isError = true;
		}
		if(!isError){
			itemDbUtil dbUtil = new itemDbUtil();
			
			String userAdded = dbUtil.addUser(email, password);
			
			if(userAdded.equals("already registered")){
				error = "email already registered";
				request.setAttribute("alreadyRegistered",error);
				isError = true;
			}
		}
		
		if(isError){
			RequestDispatcher dispatcher = request.getRequestDispatcher("signUp.jsp");
			dispatcher.forward(request, response);
		}
		
		else{
			HttpSession session = request.getSession();
			session.setAttribute("userEmail",email);
			response.sendRedirect("homePage.jsp");
		}
		
	}

}
