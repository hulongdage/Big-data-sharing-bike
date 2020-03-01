package cn.tedu.nybike.service;

import java.util.ArrayList;
import java.util.List;

import cn.tedu.nybike.dao.TripDAO;
import cn.tedu.nybike.pojo.CusSubVO;
import cn.tedu.nybike.pojo.CustomDO;
import cn.tedu.nybike.pojo.Demo1DO;
import cn.tedu.nybike.pojo.Demo1VO;
import cn.tedu.nybike.pojo.Demo3DO;
import cn.tedu.nybike.pojo.Demo3VO;
import cn.tedu.nybike.pojo.Demo4DO;
import cn.tedu.nybike.pojo.Demo4VO;
import cn.tedu.nybike.pojo.Demo5DO;
import cn.tedu.nybike.pojo.WeatherDO;
import cn.tedu.nybike.pojo.dhcVO;
import cn.tedu.nybike.pojo.newDemo3Do;
import cn.tedu.nybike.pojo.newDemo3Vo;

public class TripService {

	private TripDAO dao = new TripDAO();
	
	
	public newDemo3Vo findHourCount2() {
		 newDemo3Vo demo3Vo = new newDemo3Vo();
		List<newDemo3Do> list = dao.listHourCount2();
		List<Integer> hours=new ArrayList<Integer>(list.size());
		List<Integer> counts=new ArrayList<Integer>(list.size());
		for (newDemo3Do demo3Do : list) {
			hours.add(demo3Do.getHour());
			counts.add(demo3Do.getCount());
		}
		demo3Vo.setCounts(counts);
		demo3Vo.setHours(hours);
		return demo3Vo;
	}
	
	public Demo3VO findHourCount1() {		
		List<Demo3DO> list = dao.listHourCount1();
		//将数据按照页面需求填充到vo中
		ArrayList<Integer> hours = new ArrayList<Integer>(list.size());
		ArrayList<Integer> counts = new ArrayList<Integer>(list.size());
		for(Demo3DO dDo : list) {
			hours.add(dDo.getHour());
			counts.add(dDo.getCount());
		}
		Demo3VO vo = new Demo3VO(hours,counts);
		return vo;
	}
	
	public dhcVO listHourDayCount() {		
		List<Demo4DO> list = dao.listHourDayCount();
	    dhcVO vo = new dhcVO(list);
		return vo;
	}
	
	public List<Demo5DO> hotPoint() {		
		List<Demo5DO> list = dao.hotPoint();
		return list;
	}
	
	public List<WeatherDO> weatherDOList() {		
		List<WeatherDO> list = dao.weatherDOList();
		return list;
	}
	
	public CusSubVO getCusSubVO() {	
		List<Long> cusList = dao.customAndSubs();
		List<Long> subList = dao.subAndSubs();
		CusSubVO vo = new CusSubVO(cusList, subList);
		return vo;
	}
}
