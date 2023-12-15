package com.test.java;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello.do")
public class Hello extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			Connection conn = DBUtil.open();
			Statement stat = conn.createStatement();
			
			String sql = "select count(*) as cnt from tabs";
			
			ResultSet rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				
				req.setAttribute("cnt", rs.getInt("cnt"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/hello.jsp");
		dispatcher.forward(req, resp);
		
	}
}
