package com.healthcare.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.healthcare.dao.PatientDao;
import com.healthcare.dao.PatientDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cancel
 */
@WebServlet("/cancel")
public class Cancel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cancel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
//			String getp = request.getParameter("id");
//			PatientDao pt = new PatientDaoImpl();
//			int deleteid= Integer.parseInt(getp);
//			String msg = pt.deleteAppointment(deleteid);
//			pw.print(msg);
			String checkdate = request.getParameter("date");
			LocalDateTime date = LocalDateTime.parse(checkdate);
			if (date.isEqual(LocalDateTime.now())) {
				pw.print("cant delete today's appointments");
			} else {
				String getp = request.getParameter("id");
				PatientDao pt = new PatientDaoImpl();
				int deleteid = Integer.parseInt(getp);
				String msg = pt.deleteAppointment(deleteid);
				pw.print(msg);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

}
