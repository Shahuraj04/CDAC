package com.flight.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.flight.dao.FlightDao;
import com.flight.dao.FlightDaoImpl;
import com.flight.pojo.Flight;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class DisplayFlightDetailsServlet
 */
@WebServlet("/display_details")
public class DisplayFlightDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FlightDao flightdao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			flightdao = new FlightDaoImpl();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession hs= request.getSession();
		
		
		try (PrintWriter pw = response.getWriter()) {
			String flight_id= request.getParameter("id");
			
			int f_id=  Integer.parseInt(flight_id);
			hs.setAttribute("flight_id", f_id);
			Flight flight = flightdao.selectedFlight(f_id);
			pw.print("<h3>Thank You For selecting Flight</h3>");
			pw.print("<h5>"+"You've selected"+"  "+flight.getAirline()+"         <b style='color: navy'>"+flight.getSource()+"</b> to <b style='color: navy'>"+flight.getDestination()+"</b>  price: <b style='color: navy'>"+flight.getPrice()+"</b></h5>");
			pw.print("<button><a href='passenger_details.html'>Confirm</a></button>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
