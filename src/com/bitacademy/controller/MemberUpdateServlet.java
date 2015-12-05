package com.bitacademy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitacademy.dao.MemberDAO;
import com.bitacademy.dto.MemberVO;

@WebServlet("/memberUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid=request.getParameter("userid");
		MemberDAO memDao=MemberDAO.getInstance();
		
		MemberVO memVo=memDao.getMember(userid);
		request.setAttribute("memVo", memVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("web-study-09/memberUpdate.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String userid=request.getParameter("userid");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		int admin=Integer.parseInt(request.getParameter("admin"));
		
		MemberVO memVo=new MemberVO();
		memVo.setUserid(userid);
		memVo.setPwd(pwd);
		memVo.setEmail(email);
		memVo.setPhone(phone);
		memVo.setAdmin(admin);
		
		MemberDAO memDao=MemberDAO.getInstance();
		
		memDao.updateMember(memVo);
		response.sendRedirect("login.do");
				
		
	}

}
