	package com.cdac.pages;
	
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.sql.SQLException;
	
	import com.healtcare.doa.HealthDao;
	import com.healtcare.doa.HealthDaoImpl;
	
	import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;
	
	@WebServlet("/delete")
	public class DeletePatient extends HttpServlet {
		private static final long serialVersionUID = 1L;
	
		public void init() throws ServletException {
		}
	
		public void destroy() {
	
		}
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			response.setContentType("text/html");
			try(PrintWriter pw = response.getWriter()){
				String s= request.getParameter("id");
				int i = Integer.parseInt(s);
				HealthDao dr =new HealthDaoImpl();
				pw.write(dr.deleltePatient(i));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
	
	}
