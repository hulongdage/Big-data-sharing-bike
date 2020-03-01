package cn.tedu.nybike.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.nybike.listener.MySCListener;


public class StatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = this.getServletContext();
		//��Ӷ�������
		MySCListener.lock.readLock().lock();
		//��servletContext�л�ȡ��������
		String infoData = sc.getAttribute("statusData").toString();
		//�ͷŶ���
		MySCListener.lock.readLock().unlock();
		//֪ͨ�����,������Ӧ������json��ʽ
		response.setContentType("application/json;charset=utf-8");
		//���������ݷ���
		response.getWriter().write(infoData);
	}

}
