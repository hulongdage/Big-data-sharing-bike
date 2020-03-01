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
		//��VOת��JSON�ַ���
		String jsonStr = JSON.toJSONString(vo);
		//֪ͨ����������η�������ΪJSON��ʽ
		response.setContentType("appliction/json;charset=utf-8");
		//����json�ַ���
		response.getWriter().write(jsonStr);
	}

}
