package com.bitacademy.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddMember")
public class AddMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String url="jdbc:oracle:thin:@localhost:1522:XE";
		String uid="testdb";
		String pass="1111";
		
		String sql="insert into member values(?,?,?,?,?,?)";
		
		request.setCharacterEncoding("UTF-8");
		
		String name=request.getParameter("name");
		String userid=request.getParameter("userid");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String admin=request.getParameter("admin");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn=DriverManager.getConnection(url,uid,pass);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, userid);
			pstmt.setString(3, pwd);
			pstmt.setString(4, email);
			pstmt.setString(5, phone);
			pstmt.setInt(6, Integer.parseInt(admin));
			
			pstmt.executeQuery();			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(pstmt!=null)
				try {
					pstmt.close();
					if(conn !=null) conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			
		}
		
		
	}

}
