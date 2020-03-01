package cn.tedu.nybike.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.tedu.nybike.pojo.Demo2VO;
import cn.tedu.nybike.service.StatusService;

public class Demo2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StatusService service = new StatusService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sidStr = request.getParameter("sid");
		int sid = 0;
		if(sidStr != null) {
			sid = Integer.parseInt(sidStr);
		}
		Demo2VO vo = service.findStatusById(sid);
		//将VO转成JSON字符串
		String jsonStr = JSON.toJSONString(vo);
		//通知浏览器，本次返回内容为JSON格式
		response.setContentType("appliction/json;charset=utf-8");
		//返回json字符串
		response.getWriter().write(jsonStr);
	}

}
