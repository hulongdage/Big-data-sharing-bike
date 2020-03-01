package cn.tedu.nybike.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cn.tedu.nybike.dao.StatusDao;
import cn.tedu.nybike.pojo.Demo1DO;
import cn.tedu.nybike.pojo.Demo1VO;
import cn.tedu.nybike.pojo.Demo2DO;
import cn.tedu.nybike.pojo.Demo2VO;
import cn.tedu.nybike.util.TimeUtil;

public class StatusService {
    private StatusDao dao = new StatusDao();
	public Demo1VO findStatus() {
		Demo1VO vo = new Demo1VO();
		List<Demo1DO> list = dao.listStatus();
		//将数据按照页面需求填充到vo中
		ArrayList<Integer> sids = new ArrayList<Integer>(list.size());
		ArrayList<Integer> nbas = new ArrayList<Integer>(list.size());
		for(Demo1DO dDo : list) {
			sids.add(dDo.getSid());
			nbas.add(dDo.getNba());
		}
		vo.setxData(sids);
		vo.setyData(nbas);
		return vo;
	}
	
	public Demo2VO findStatusById(int sid) {
		List<Demo2DO> list = dao.listStatusById(sid);
		List<String> times = new ArrayList<String>(list.size());
		List<Integer> nbas = new ArrayList<Integer>(list.size());
		List<Integer> ndas = new ArrayList<Integer>(list.size());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		for(Demo2DO dDO : list) {
			times.add(TimeUtil.getNewyorkTime(dDO.getTime(), sdf));
			nbas.add(dDO.getNba());
			ndas.add(dDO.getNda());
		}
		Demo2VO vo = new Demo2VO(times, nbas, ndas);
		return vo;
		
	}
}
