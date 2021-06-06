package bank.controller;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.service.Service;

public class LoginController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
	
		
		Service s = Service.getInstance();
		boolean result = s.login(id,pwd);
		String path = null;
		if(result)
		{
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			path="/menu.jsp";	// 로그인 성공했을 때 가야하는 경로
		}
		else
		{ 
			path="/index.jsp";   	//실패했을 때
		}
		HttpUtil.forward(request, response, path);
	}
}
