package cn.tedu.test;

import java.util.List;

import org.junit.Test;

import cn.tedu.nybike.dao.TripDAO;
import cn.tedu.nybike.pojo.Demo3DO;
import cn.tedu.nybike.pojo.Demo4DO;
import cn.tedu.nybike.pojo.WeatherDO;

public class TripDAOTest {
    
	TripDAO dao = new TripDAO();
	
	@Test
	public void listHourCount1() {
		List<Demo4DO> list = dao.listHourDayCount();
		for(Demo4DO dDO : list) {
			System.out.println(dDO);
		}
	}
	
	@Test
	public void weather() {
		List<WeatherDO> list = dao.weatherDOList();
		for(WeatherDO dDO : list) {
			System.out.println(dDO);
		}
	}
}
