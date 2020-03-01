package cn.tedu.nybike.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.tedu.nybike.pojo.Demo4VO;
import cn.tedu.nybike.pojo.dhcVO;
import cn.tedu.nybike.service.TripService;

public class Demo4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    TripService service = new TripService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    dhcVO vo = service.listHourDayCount();
		//将VO转成JSON字符串
		String jsonStr = JSON.toJSONString(vo);
		//通知浏览器，本次返回内容为JSON格式
		response.setContentType("appliction/json;charset=utf-8");
		//返回json字符串
		response.getWriter().write(jsonStr);
	}

}
