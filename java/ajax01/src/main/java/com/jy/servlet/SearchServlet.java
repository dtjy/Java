/*
 *******************************************************************************
 * @FileName	SearchServlet.java
 * @package		com.jy.servlet
 * @author		jy·DT
 * @Date		2018年1月30日 下午10:53:47
 * @description 
 *******************************************************************************
 */
package com.jy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 ******************************************
 * @author jy·DT  [2018年1月30日 下午10:53:47]
 ******************************************
 */
public class SearchServlet extends HttpServlet{
	private static List<String> datas;
	//模拟数据
	static{
		datas = new ArrayList<String>();
		datas.add("ajax");
		datas.add("ajax12");
		datas.add("ajax3");
		datas.add("ccc3");
		datas.add("ccc4");
		datas.add("ccc56");
		datas.add("c2c2c");
		datas.add("c0c2c");
		datas.add("c2c2c");
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println(123456);
		String keyword = req.getParameter("keyword");
		//获取相关的数据
		List<String> list = this.getData(keyword);
		Gson gson = new Gson();
		
		System.out.println(gson.toJson(list));
		//返回JSON格式
		PrintWriter pw = res.getWriter();
		pw.write(gson.toJson(list));
		pw.flush();
		pw.close();
	}
	
	/**
	 * 查询函数
	 * [2018年1月30日 下午11:23:24]
	 * @param keyword 查询关键字
	 * @return 查询结果list
	 */
	public List<String> getData(String keyword){
		List<String> list = new ArrayList<String>();
		for(String data:datas){
			//个人觉得需要展示的是输入的数据为前缀，而不是包含
			if(data.startsWith(keyword)){
//				data.contains(keyword)
				list.add(data);
			}
		}
		return list;
	}
}
