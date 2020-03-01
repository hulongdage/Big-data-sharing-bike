package cn.tedu.nybike.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.tedu.nybike.pojo.Demo5DO;
import cn.tedu.nybike.service.TripService;

public class HotPointServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TripService service = new TripService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Demo5DO> list = service.hotPoint();
		//��listת��JSON�ַ���
		String jsonStr = JSON.toJSONString(list);
		//֪ͨ����������η�������ΪJSON��ʽ
		response.setContentType("appliction/json;charset=utf-8");
		//����json�ַ���
		response.getWriter().write(jsonStr);
	}

}
