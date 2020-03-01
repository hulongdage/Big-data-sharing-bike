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
		//��VOת��JSON�ַ���
		String jsonStr = JSON.toJSONString(vo);
		//֪ͨ����������η�������ΪJSON��ʽ
		response.setContentType("appliction/json;charset=utf-8");
		//����json�ַ���
		response.getWriter().write(jsonStr);
	}

}
