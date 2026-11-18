package com.office.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("*.mem")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String commend = requestURI.substring(contextPath.length());
		
		IMemberService memberService = null;
		String nextPage = null;
		
		switch (commend) { 
		case "/signup_form.mem": 
			
			nextPage = "view/member/signup_form.jsp";
			
			break;
			
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		requestDispatcher.forward(request, response);
		
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
