package cn.tedu.nybike.dao;

import java.util.List;

import org.junit.Test;

import cn.tedu.nybike.pojo.Demo1DO;
import cn.tedu.nybike.pojo.Demo2DO;

public class StatusDAOTest {
	 StatusDao dao = new StatusDao();
	 @Test
     public void listStatus() {
    	 List<Demo1DO> list = dao.listStatus();
    	 for(Demo1DO dDO : list) {
    		 System.out.println(dDO);
    	 }
     }
	 
	 @Test
     public void listStatusById() {
    	 List<Demo2DO> list = dao.listStatusById(323);
    	 System.out.println(list.size());
    	 for(Demo2DO dDO : list) {
    		 System.out.println(dDO);
    	 }
    	 
     }
}
