package com.flight.pages;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.flight.dao.FlightDao;
import com.flight.dao.FlightDaoImpl;


@WebServlet("/search_result")
public class SearchResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FlightDao flightdao;
       

    public SearchResult() {
       
       
    }


	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			flightdao = new FlightDaoImpl();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			try(PrintWriter pw = response.getWriter()){
				
				
			}
			
			
	}

}
