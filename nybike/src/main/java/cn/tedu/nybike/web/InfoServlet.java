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
		//添加读锁对象
		MySCListener.lock.readLock().lock();
		//从servletContext中获取缓存数据
		String infoData = sc.getAttribute("infoData").toString();
		//释放读锁
		MySCListener.lock.readLock().unlock();
		//通知浏览器,本次响应数据是json格式
		resp.setContentType("application/json;charset=utf-8");
		//将缓存数据发送
		resp.getWriter().write(infoData);
		
	}

}
