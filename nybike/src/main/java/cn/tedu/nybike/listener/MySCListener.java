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
    //����һ����д������
	public static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//ͨ���¼�����,��ȡ
		ServletContext sc = sce.getServletContext();
		//�������̶߳���
		Thread t1 = new Thread(new Runnable() {		
			@Override
			public void run() {
				//�����Է�������,��ȡվ������
				while(true) {
					String infoData = HttpUtil.get(infoUrl);
					String statusData = HttpUtil.get(statusUrl);
					String time = new Date().toLocaleString();
					lock.writeLock().lock();
					//�����ݱ��浽application����
					sc.setAttribute("infoData", infoData);
					sc.setAttribute("statusData", statusData);
					System.out.println(statusData+infoData);
					lock.writeLock().unlock();
					try {
						//ÿ30������һ��
						Thread.sleep(30*1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			}
		});	
		//�������߳�
		t1.start();
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	
	}

}
