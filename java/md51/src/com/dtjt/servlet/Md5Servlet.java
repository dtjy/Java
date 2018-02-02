/*
 *******************************************************************************
 * @FileName	Md5Servlst.java
 * @package		com.dtjt.servlet
 * @author		jy·DT
 * @Date		2018年2月1日 下午8:32:52
 * @description 
 *******************************************************************************
 */
package com.dtjt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dtjt.entity.User;
import com.dtjt.service.UserService;
import com.google.gson.Gson;

/**
 * servlet
 ******************************************
 * @author jy·DT  [2018年2月1日 下午8:32:52]
 ******************************************
 */
public class Md5Servlet extends HttpServlet{
	
	/**
	 * [2018年2月2日 上午2:07:49]
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=UTF-8");
		try{
			String method = req.getParameter("method");
			PrintWriter pw = res.getWriter();
			//新增
			if(Objects.equals(method, "add")){
				add(req, pw);
			}
			//条件查看看
			if(Objects.equals(method, "find_by")){
				findBy(req, pw);
			}
			//查看全部
			if(Objects.equals(method, "find_all")){
				findAll(pw);
			}
			//更改
			if(Objects.equals(method, "update")){
				update(req, pw);
			}
			//删除
			if(Objects.equals(method, "delete")){
				delete(req, pw);
			}
			
		}catch(Exception e){
			
		}
	}

	/**
	 * 删除操作
	 * [2018年2月2日 下午4:38:53]
	 * @param req
	 * @param pw
	 * @throws SQLException
	 */
	private void delete(HttpServletRequest req, PrintWriter pw) throws SQLException {
		String ids = req.getParameter("ids");
		String reslut = "";
		if(ids==null||"".equals(ids)){
			reslut = "请先选择要删除的数据";
		}else{
			reslut = this.userService.delete(ids);
		}
		pw.println(reslut);
		pw.flush();
		pw.close();
	}

	/**
	 * 跟新操作
	 * [2018年2月2日 下午4:39:04]
	 * @param req
	 * @param pw
	 * @throws UnsupportedEncodingException
	 * @throws SQLException
	 */
	private void update(HttpServletRequest req, PrintWriter pw) throws UnsupportedEncodingException, SQLException {
		String idStr = req.getParameter("id");
		String reslut = "";
		if(idStr==null||"".equals(idStr)){
			reslut = "请先选择要修改的数据";
		}else{
			int id = Integer.parseInt(idStr);
			String comp = transEncoder(req.getParameter("comp"));
			String account = transEncoder(req.getParameter("account"));
			String password = transEncoder(req.getParameter("password"));
			User user = new User(comp, account, password);
			user.setId(id);
			reslut = this.userService.update(user);
		}
		pw.println(reslut);
		pw.flush();
		pw.close();
	}

	/**
	 * 查询全部
	 * [2018年2月2日 下午4:39:18]
	 * @param pw
	 * @throws SQLException
	 */
	private void findAll(PrintWriter pw) throws SQLException {
		List<User> list = this.userService.findAll();
		Gson gson = new Gson();
		pw.println(gson.toJson(list));
		pw.flush();
		pw.close();
	}

	/**
	 * 条件查询
	 * [2018年2月2日 下午4:39:27]
	 * @param req
	 * @param pw
	 * @throws UnsupportedEncodingException
	 * @throws SQLException
	 */
	private void findBy(HttpServletRequest req, PrintWriter pw) throws UnsupportedEncodingException, SQLException {
		String condition = req.getParameter("condition");
		condition = transEncoder(condition);
		List<User> list = this.userService.findBy(condition);
		Gson gson = new Gson();
		pw.println(gson.toJson(list));
		pw.flush();
		pw.close();
	}

	/**
	 * 新增操作 
	 * [2018年2月2日 下午4:39:39]
	 * @param req
	 * @param pw
	 * @throws UnsupportedEncodingException
	 * @throws SQLException
	 */
	private void add(HttpServletRequest req, PrintWriter pw) throws UnsupportedEncodingException, SQLException {
		String comp = req.getParameter("comp");
		String account = req.getParameter("account");
		String password = req.getParameter("password");
		
		comp = transEncoder(comp);
		account = transEncoder(account);
		password = transEncoder(password);
		User user = new User(comp, account, password);
		String result = this.userService.add(user);
		pw.println(result);
		pw.flush();
		pw.close();
	}
	
	/**
	 * 浏览器到服务器端乱码转换
	 * [2018年2月2日 上午11:11:48]
	 * @return 转换结果
	 * @throws UnsupportedEncodingException 
	 */
	public String transEncoder(String str) throws UnsupportedEncodingException{
		str = URLEncoder.encode(str, "ISO-8859-1");
	    // 再进行utf-8编码 一次得到页面上输入的文本内容
		str = URLDecoder.decode(str, "UTF-8");
		return str;
	}
	
}
