package com.demo.mvc.testjdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestJdbcServlet
 */
@WebServlet("/TestJdbcServlet")
public class TestJdbcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// setup connection varaibles
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/web_student_tracker?serverTimezone=UTC";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get connection to database
		Connection conn = null;
		try {
			PrintWriter out = response.getWriter();
			
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			
			if(conn != null) {
				out.println("connect to db successfully");
			} else {
				out.println("failed to connect to db");
			}
		
		} catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		// close connection
		finally {
			try {
				if(conn != null) {
					conn.close();
				}				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
