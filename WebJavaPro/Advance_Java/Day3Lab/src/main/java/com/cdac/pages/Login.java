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

import com.healtcare.doa.HealthDao;
import com.healtcare.doa.HealthDaoImpl;
import com.healthcare.pojo.Patient;

@WebServlet(value = "/authenticate",loadOnStartup = 1)
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
			
	}

	public void destroy() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter()){
			String mail = request.getParameter("em");
			String password = request.getParameter("pass");
			HealthDao dr =new HealthDaoImpl();
		 Patient p	=dr.PatientSignIn(mail, password);
		 
			if(p!=null) {
				pw.print("Success");
			}
			else{pw.print("Error");}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
