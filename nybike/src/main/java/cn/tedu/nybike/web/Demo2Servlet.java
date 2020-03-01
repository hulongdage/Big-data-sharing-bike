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
		//��VOת��JSON�ַ���
		String jsonStr = JSON.toJSONString(vo);
		//֪ͨ����������η�������ΪJSON��ʽ
		response.setContentType("appliction/json;charset=utf-8");
		//����json�ַ���
		response.getWriter().write(jsonStr);
	}

}
