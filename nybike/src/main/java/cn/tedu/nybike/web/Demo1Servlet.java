package cn.tedu.nybike.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.tedu.nybike.pojo.Demo1VO;
import cn.tedu.nybike.service.StatusService;

public class Demo1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	StatusService service = new StatusService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Demo1VO vo = service.findStatus();
		//将VO转成JSON字符串
		String jsonStr = JSON.toJSONString(vo);
		//通知浏览器，本次返回内容为JSON格式
		response.setContentType("appliction/json;charset=utf-8");
		//返回json字符串
		response.getWriter().write(jsonStr);
	}

}
