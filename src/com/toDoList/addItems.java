package com.toDoList;

import java.util.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class addItems
 */
@WebServlet("/addItems")
public class addItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	// making an array list globally in servlet do that the items do not change when reload
	ArrayList<item> items = new ArrayList<item>();
	
    public addItems() {
        super();
        // TODO Auto-generated constructor stub
    }
    
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get item form home.jsp
		String label = request.getParameter("ItemLabel");
		
		// get date from home.jsp
		String date = request.getParameter("ItemDate");
		
		// get time from home.jsp
		String time = request.getParameter("ItemTime");
		
		HttpSession session = request.getSession();
		
		String email = (String) session.getAttribute("userEmail");
		
		itemDbUtil dbUtil = new itemDbUtil();
		//checking if there is no item
		if(label.length() > 0 || date.length() > 0 || time.length() > 0)
			dbUtil.addItem(new item(label, date, time), email);
		
		// making an html attribute
		request.setAttribute("listItems", dbUtil.getItems(email));
		
		// making a request dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("homePage.jsp");
		
		// send list to home.jsp
		dispatcher.forward(request, response);
		
	}

}
