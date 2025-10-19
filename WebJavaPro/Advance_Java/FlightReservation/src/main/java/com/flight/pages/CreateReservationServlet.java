package com.flight.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import com.flight.dao.FlightDao;
import com.flight.dao.FlightDaoImpl;
import com.flight.dao.ReservationDao;
import com.flight.dao.ReservationDaoImpl;
import com.flight.pojo.Customer;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class CreateReservationServlet
 */
@WebServlet("/reservation")
public class CreateReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FlightDao flightdao;
	ReservationDao reservationDao;

	public void init(ServletConfig config) throws ServletException {
		try {
			flightdao = new FlightDaoImpl();
			reservationDao = new ReservationDaoImpl();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession hs = request.getSession();

		int i = (Integer) hs.getAttribute("flight_id");
		try (PrintWriter pw = response.getWriter()) {
			Customer c = reservationDao.getData(request.getParameter("customer_email"));
			if (flightdao.validateCustomer(request.getParameter("customer_email"),
					request.getParameter("customer_pswd"))) {
				LocalDate localDate = LocalDate.now();
				Date sqlDate = Date.valueOf(localDate);
					System.out.println(c.getCustomer_phno());
				reservationDao.reserveSeat(sqlDate, c.getCustomer_email(), c.getCustomer_f_name(),
						c.getCustomer_l_name(), c.getCustomer_phno(), i);
				System.out.println(c.getId());;
				pw.print("<h2 style='color:green'>Flight Reserved Successfully!!1</h3>");
			} else {
				pw.print("<h2 style='color:red'>Login Failed</h2>");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
