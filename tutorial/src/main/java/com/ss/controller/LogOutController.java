package com.ss.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogOutcontroller
 */
public class LogOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogOutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String userName=(String)request.getSession(false).getAttribute("username");
         System.out.println("*****");
         System.out.println("userName "+userName);
		if(userName!=null){
		HttpSession session = request.getSession(false); 	
		session.removeAttribute("userName");
		//session.setAttribute("username", null);
		
		  response.setHeader("Cache-Control","no-cache");
		  response.setHeader("Cache-Control","no-store");
		  response.setHeader("Pragma","no-cache");
		  response.setDateHeader ("Expires", 0);
		  if(session.getAttribute("userName")==null)
		  { session.invalidate();
			  response.sendRedirect("jsp/index.jsp");
		  }
      /*  RequestDispatcher rd=request.getRequestDispatcher("jsp/index.jsp");
        rd.forward(request, response);*/
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
		
	}

}
