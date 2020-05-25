package com.toDoList;

import java.util.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	ArrayList<String> items = new ArrayList<String>();
	
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
		String item = request.getParameter("theItem");
		
		//checking if there is no item
		if(item != null && item.length() > 0)
			items.add(item);
		
		// making an html attribute
		request.setAttribute("listItems", items);
		
		// making a request dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("homePage.jsp");
		
		// send list to home.jsp
		dispatcher.forward(request, response);
		
	}

}
