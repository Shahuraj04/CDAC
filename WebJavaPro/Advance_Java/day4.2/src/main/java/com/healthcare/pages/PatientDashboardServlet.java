package com.healthcare.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.healthcare.dao.PatientDao;
import com.healthcare.dao.PatientDaoImpl;
import com.healthcare.pojos.Appointments;
import com.healthcare.pojos.Patient;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class PatientDashboardServlet
 */
@WebServlet("/patient_dashboard")
public class PatientDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			pw.print("<h4> Welcome to Patient Dashboard....</h4>");
			// 1. get HttpSession from WC
			HttpSession hs = request.getSession();
			
			Patient patient = (Patient) hs.getAttribute("patient_details");
			
			PatientDao pat = new PatientDaoImpl();
			
			if (patient != null) {
				pw.print("<h5> Patient details from HttpSession " + patient + "</h5>");
				Patient p = (Patient) hs.getAttribute("patient_details");
				List<Appointments> list =    pat.showAllAppointments(p.getId());
				pw.print("<style>\r\n"
						+ "        table,\r\n"
						+ "        th,\r\n"
						+ "        td {\r\n"
						+ "            border: 1px solid black;\r\n"
						+ "        }\r\n"
						+ "    </style>");
				pw.print("<table style='border:2px solid black;padding:8px,margin:8px' >");
				pw.print("<tr><td style:'border: 1px solid black'>AppointmentId</<td>"
						+ "<td>Date Time</td>"
						+"<td>Doc name</td>"+"<td></td>"+"</tr>");
				for(Appointments a : list) {
					pw.print("<tr><td>" + a.getId() + "</td>"
					        + "<td>" + a.getDate() + "</td>"
					        + "<td>" + a.getDname() + "</td>"
					        + "<td><a href='cancel?id=" + a.getId() + "&date=" + a.getDate() + "' class='button'>Cancel</a></td></tr>");

				}
				pw.print("</table>");
				pw.print("<button type='button'><a href='bookappointment.html'>BookAppointment</button>");
			} else {
				pw.print("<h5> You will have to accept the cookies , to continue....</h5>");
			}
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
