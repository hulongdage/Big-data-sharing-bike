package cn.tedu.nybike.listener;

import java.util.Date;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import cn.tedu.nybike.util.HttpUtil;

public class MySCListener implements ServletContextListener{
	private String infoUrl = "https://gbfs.citibikenyc.com/gbfs/en/station_information.json";
	private String statusUrl="https://gbfs.citibikenyc.com/gbfs/en/station_status.json";
    //声明一个读写锁对象
	public static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//通过事件对象,获取
		ServletContext sc = sce.getServletContext();
		//创建子线程对象
		Thread t1 = new Thread(new Runnable() {		
			@Override
			public void run() {
				//周期性发送请求,获取站点数据
				while(true) {
					String infoData = HttpUtil.get(infoUrl);
					String statusData = HttpUtil.get(statusUrl);
					String time = new Date().toLocaleString();
					lock.writeLock().lock();
					//将数据保存到application域中
					sc.setAttribute("infoData", infoData);
					sc.setAttribute("statusData", statusData);
					System.out.println(statusData+infoData);
					lock.writeLock().unlock();
					try {
						//每30秒请求一次
						Thread.sleep(30*1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			}
		});	
		//启动子线程
		t1.start();
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	
	}

}
