package cn.tedu.nybike.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.tedu.nybike.pojo.newDemo3Vo;
import cn.tedu.nybike.service.TripService;


public class Demo3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TripService service=new TripService();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		newDemo3Vo demo3Vo = service.findHourCount2();
		String jsonString = JSON.toJSONString(demo3Vo);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(jsonString);
	}
}
