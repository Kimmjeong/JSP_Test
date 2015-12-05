package com.bitacademy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitacademy.dao.MemberDAO;
import com.bitacademy.dto.MemberVO;

@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("web-study-09/join.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.setCharacterEncoding("UTF-8"); // 요청한 값
		
		String name=request.getParameter("name");
		String userid=request.getParameter("userid");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		int admin=Integer.parseInt((request.getParameter("admin")));
		
		
		System.out.println("1  "+name);
		
		MemberVO memVo=new MemberVO();
		
		memVo.setName(name);
		memVo.setUserid(userid);
		memVo.setPwd(pwd);
		memVo.setEmail(email);
		memVo.setPhone(phone);
		memVo.setAdmin(admin);
		
		System.out.println("2  "+memVo.getName());
		
		
		MemberDAO memDao=MemberDAO.getInstance();
		int result=memDao.insertMember(memVo);
		
		HttpSession session=request.getSession();
		
		if(result==1){
			session.setAttribute("userid", memVo.getUserid());
			request.setAttribute("message","회원 가입에 성공했습니다." );
		}
		else
			request.setAttribute("message", "회원 가입에 실패했습니다.");
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("web-study-09/login.jsp");
		dispatcher.forward(request, response);
	}

}
