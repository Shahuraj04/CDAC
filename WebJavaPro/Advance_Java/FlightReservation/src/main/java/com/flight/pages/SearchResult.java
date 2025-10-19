package com.flight.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.flight.dao.FlightDao;
import com.flight.dao.FlightDaoImpl;
import com.flight.pojo.Flight;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			String source = request.getParameter("selected_source");
			String destination = request.getParameter("selected_destination");
			Date date = Date.valueOf(request.getParameter("daparture_date"));
			System.out.println(source);
			System.out.println(destination);
			System.out.println(date);
			List<Flight> flightList = flightdao.showList(source, destination, date);
			if (!flightList.isEmpty()) {
				pw.print("<h3>Flights for " + destination + " from " + source + "</h3>");

				pw.print("<table border='1' style='border-collapse: collapse; width: 80%; margin: auto;'>");
				pw.print("<tr style='background-color: lightgray;'>");
				pw.print("<th>Flight ID</th>");
				pw.print("<th>Airline</th>");
				pw.print("<th>Source</th>");
				pw.print("<th>Destination</th>");
				pw.print("<th>Departure Date</th>");
				pw.print("<th>Departure Time</th>");
				pw.print("<th>Price</th>");
				pw.print("<th>		</th>");
				pw.print("</tr>");

				for (Flight dao : flightList) {
					pw.print("<tr style='text-align: center;'>");
					pw.print("<td>" + dao.getFlight_id() + "</td>");
					pw.print("<td>" + dao.getAirline() + "</td>");
					pw.print("<td>" + dao.getSource() + "</td>");
					pw.print("<td>" + dao.getDestination() + "</td>");
					pw.print("<td>" + dao.getDeparture_date() + "</td>");
					pw.print("<td>" + dao.getDeparture_time() + "</td>");
					pw.print("<td>" + dao.getPrice() + "</td>");
					pw.print("<td><a href='display_details?id=" + dao.getFlight_id()
							+ "'><button>Book</button></a></td>");
					pw.print("</tr>");
				}

				pw.print("</table>");
			} else {
				pw.print("<h3>No flights available for the given source and date</h3>");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
