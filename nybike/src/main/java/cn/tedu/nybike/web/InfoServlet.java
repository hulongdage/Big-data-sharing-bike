package cn.tedu.nybike.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.nybike.listener.MySCListener;

public class InfoServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext sc = this.getServletContext();
		//��Ӷ�������
		MySCListener.lock.readLock().lock();
		//��servletContext�л�ȡ��������
		String infoData = sc.getAttribute("infoData").toString();
		//�ͷŶ���
		MySCListener.lock.readLock().unlock();
		//֪ͨ�����,������Ӧ������json��ʽ
		resp.setContentType("application/json;charset=utf-8");
		//���������ݷ���
		resp.getWriter().write(infoData);
		
	}

}
