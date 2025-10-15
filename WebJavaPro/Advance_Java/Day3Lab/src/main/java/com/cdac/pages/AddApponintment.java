package com.cdac.pages;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import org.apache.coyote.Request;

import com.healtcare.doa.HealthDao;
import com.healtcare.doa.HealthDaoImpl;

/**
 * Servlet implementation class AddApponintment
 */
@WebServlet("/addappointment")
public class AddApponintment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void init() throws ServletException {
			}

	
	public void destroy() {
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter()){
			String s1= request.getParameter("id");
			String s2 = request.getParameter("docid");
			String s3 = request.getParameter("patid");
			String s4 = request.getParameter("date");
			int id1=Integer.parseInt(s1);
			int id2=Integer.parseInt(s2);
			int id3=Integer.parseInt(s3);
			HealthDao dr =  new HealthDaoImpl();
			
			String result  = dr.addAppointment(id2, id3, s4); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

}
