package com.cdac.pages;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(value = "/calculate", loadOnStartup = 1)
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
		/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy" + getClass());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In do get"+getClass());
		// set response type
		response.setContentType("text/html");
		// get the witer to send response
		
		
//		switch (request.getParameter("action")) {
//		case "add": {
//			System.out.println(n1+n2);
//				break;
//				
//		}
//		case "subtract": {
//			System.out.println(n1-n2);
//				break;
//				
//		}
//		default:
//			throw new IllegalArgumentException("Unexpected value: " + request.getParameter("num2"));
		//}
		try (PrintWriter out = response.getWriter()) {
			String n1Str =request.getParameter("num1") ;
			String n2Str =request.getParameter("num2") ;
			int n1=Integer.parseInt(n1Str);
			int n2=Integer.parseInt(n2Str);
			String operation = request.getParameter("action");
			double result;
			switch (operation) {
			case "add": {
				result= n1+ n2;			
				break;
			}
			case "subtract": {
				result=n1-n2;			
			break;
		}
			case "multiply": {
				result=n1*n2;			
			break;
		}
			case "divide": {
				result=n1/n2;			
			break;
		}
			default:
				throw new IllegalArgumentException("Unexpected value: " + operation);
			}
			out.print("<h5>Result of "+operation+" is"+result+"</h5>");
		}
	}

}
