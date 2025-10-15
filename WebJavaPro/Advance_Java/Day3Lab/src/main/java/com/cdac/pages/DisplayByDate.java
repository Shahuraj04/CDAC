package com.cdac.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.healtcare.doa.HealthDao;
import com.healtcare.doa.HealthDaoImpl;
import com.healthcare.pojo.Patient;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/displaybydate", loadOnStartup = 1)
public class DisplayByDate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		try (PrintWriter pw = response.getWriter()) {

			String strd1 = request.getParameter("d1");
			String strd2 = request.getParameter("d2");

			Date d1 = Date.valueOf(strd1);
			Date d2 = Date.valueOf(strd2);

			HealthDao dao = new HealthDaoImpl();

			List<Patient> patients = dao.displayByDob(strd1, strd2);

			pw.println("<h2>Patients born between " + d1 + " and " + d2 + "</h2>");
			if (patients.isEmpty()) {
				pw.println("<p>No patients found for the selected date range.</p>");
			} else {
				pw.println("<table border:1 solid black>");
				pw.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>DOB</th></tr>");
				for (Patient p : patients) {
					pw.println("<tr>");
					pw.println("<td>" + p.getId() + "</td>");
					pw.println("<td>" + p.getPname() + "</td>");
					pw.println("<td>" + p.getPemail() + "</td>");
					pw.println("<td>" + p.getPdob() + "</td>");
					pw.println("</tr>");
				}
				pw.println("</table>");
			}

		} catch (SQLException e) {
			throw new ServletException("Database error while displaying patients by date", e);
		} catch (IllegalArgumentException e) {
 			response.getWriter().println("<h3 style='color:red'>Invalid date format. Please use yyyy-MM-dd.</h3>");
		}
	}
}
