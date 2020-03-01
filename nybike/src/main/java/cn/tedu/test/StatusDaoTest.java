package cn.tedu.test;

import java.util.List;

import org.junit.Test;

import cn.tedu.nybike.dao.StatusDao;
import cn.tedu.nybike.pojo.Demo2DO;

public class StatusDaoTest {
StatusDao dao = new StatusDao();
	
	@Test
	public void listHourCount1() {
		List<Demo2DO> list = dao.listStatusById(323);
		for(Demo2DO dDO : list) {
			System.out.println(dDO);
		}
	}
}
