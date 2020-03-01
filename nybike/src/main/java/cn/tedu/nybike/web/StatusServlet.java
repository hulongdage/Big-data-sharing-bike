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
		//添加读锁对象
		MySCListener.lock.readLock().lock();
		//从servletContext中获取缓存数据
		String infoData = sc.getAttribute("statusData").toString();
		//释放读锁
		MySCListener.lock.readLock().unlock();
		//通知浏览器,本次响应数据是json格式
		response.setContentType("application/json;charset=utf-8");
		//将缓存数据发送
		response.getWriter().write(infoData);
	}

}
