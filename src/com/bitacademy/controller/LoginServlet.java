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

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("web-study-09/login.jsp");
		dispatcher.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		response.setCharacterEncoding("UTF-8");
		
		String url="web-study-09/login.jsp";
		
		String userid=request.getParameter("userid");
		String pwd=request.getParameter("pwd");
		
		MemberDAO memDao=MemberDAO.getInstance();
		int result=memDao.userCheck(userid, pwd);
		
		if(result==1){
			MemberVO memVo=memDao.getMember(userid);
			
			HttpSession session=request.getSession();
			session.setAttribute("loginUser", memVo);
			
			request.setAttribute("message", "회원 가입에 성공했습니다.");
			url="web-study-09/main.jsp";
		} else if(result==0){
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		} else if(result==-1){
			request.setAttribute("message", "존재하지 않는 회원입니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
