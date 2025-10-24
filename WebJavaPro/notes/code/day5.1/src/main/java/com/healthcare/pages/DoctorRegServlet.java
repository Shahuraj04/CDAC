package com.healthcare.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.healthcare.dao.DoctorDao;
import com.healthcare.dao.DoctorDaoImpl;
import com.healthcare.pojos.Doctor;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoctorRegServlet
 */
@WebServlet("/registerdoc")
public class DoctorRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private DoctorDao doctordao;

    public DoctorRegServlet() {
        super();
        
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			doctordao=new DoctorDaoImpl();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("authenticate");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter()){
			String doc_name=request.getParameter("doc_name"); 
			String doc_sp = request.getParameter("special");
			String dobParam = request.getParameter("dob");
			Date ts = Date.valueOf(dobParam);
			String doc_mail = request.getParameter("doc_mail");
			String doc_pswd= request.getParameter("pswd");
			
			Doctor dr = new Doctor(doc_name, doc_sp, doc_mail, ts);
			String msg= doctordao.signUp(dr);
			if(msg.equals("Email already registered!!!")) {
				pw.print("<h5 style='color:red;'>Email is already in use. Please choose a different email.</h5>");
			}
			else {
				response.sendRedirect("authenticate");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
