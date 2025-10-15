package com.cdac.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.healtcare.doa.HealthDao;
import com.healtcare.doa.HealthDaoImpl;
import com.healthcare.pojo.Appointments;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/show")
public class ShowAppointments extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        try (PrintWriter pw = response.getWriter()) {
            HealthDao dao = new HealthDaoImpl();
            List<Appointments> list = dao.showappointments();

            pw.println("<h2>All Appointments</h2>");
            if (list.isEmpty()) {
                pw.println("<p>No appointments found.</p>");
            } else {
                pw.println("<table border='1' cellpadding='5'>");
                pw.println("<tr><th>Doctor ID</th><th>Patient ID</th><th>Date & Time</th><th>Status</th></tr>");
                for (Appointments app : list) {
                    pw.println("<tr>");
                    pw.println("<td>" + app.getDoc_id() + "</td>");
                    pw.println("<td>" + app.getPat_id() + "</td>");
                    pw.println("<td>" + app.getDate() + "</td>");
                    pw.println("<td>" + app.getStatus() + "</td>");
                    pw.println("</tr>");
                }
                pw.println("</table>");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("<h3 style='color:red'>Database error: " + e.getMessage() + "</h3>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
