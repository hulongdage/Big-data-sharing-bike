package cn.tedu.nybike.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.tedu.nybike.pojo.CusSubVO;
import cn.tedu.nybike.service.TripService;

/**
 * Servlet implementation class CusSubServlet
 */
public class CusSubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TripService service = new TripService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CusSubVO vo = service.getCusSubVO();
		//将list转成JSON字符串
		String jsonStr = JSON.toJSONString(vo);
		//通知浏览器，本次返回内容为JSON格式
		response.setContentType("appliction/json;charset=utf-8");
		//返回json字符串
		response.getWriter().write(jsonStr);
	}

}
