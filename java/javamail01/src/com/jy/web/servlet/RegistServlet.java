package com.jy.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jy.domain.User;
import com.jy.service.UserService;
import com.jy.service.impl.UserServiceImpl;
import com.jy.utils.UUIDUtil;

@WebServlet(urlPatterns="/regist")
public class RegistServlet extends HttpServlet{
	
	/**
	 * [2018年1月30日 上午2:31:09]
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try{
			req.setCharacterEncoding("utf-8");
			res.setCharacterEncoding("utf-8");
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String nickname = req.getParameter("nickname");
			String email = req.getParameter("email");
			User user = new User();
			user.setNickname(nickname);
			user.setUsername(username);
			user.setCode(UUIDUtil.code());
			user.setStatus(0);  //状态码0未激活，1激活
			user.setEmail(email);
			user.setPassword(password);
			UserService userService = new UserServiceImpl();
			userService.save(user);
			req.setAttribute("msg", "注册成功，请邮箱激活");
			req.getRequestDispatcher("/msg.jsp").forward(req, res);
		}catch(Exception e){
			
		}
	}
}
