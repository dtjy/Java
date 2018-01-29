/*
 *******************************************************************************
 * @FileName	ActiveServlet.java
 * @package		com.jy.web.servlet
 * @author		jy·DT
 * @Date		2018年1月30日 上午3:00:22
 * @description 
 *******************************************************************************
 */
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

/**
 ******************************************
 * @author jy·DT  [2018年1月30日 上午3:00:22]
 ******************************************
 */
@WebServlet(urlPatterns="/active")
public class ActiveServlet extends HttpServlet{
	
	/**
	 * [2018年1月30日 上午3:17:16]
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try{
			req.setCharacterEncoding("utf-8");
			res.setCharacterEncoding("utf-8");
			String code = req.getParameter("code");
			UserService userService = new UserServiceImpl();
			User user = userService.findByCode(code);
			if(user!=null){
				//已经激活
				user.setStatus(1);
				user.setCode(null);
				userService.update(user);
				req.setAttribute("msg", "激活成功，请登录");
			}else{
				//激活失败
				req.setAttribute("msg", "激活失败，重新激活");
			}
			req.getRequestDispatcher("/msg.jsp").forward(req, res);
		}catch(Exception e){
			
		}
	}
}
