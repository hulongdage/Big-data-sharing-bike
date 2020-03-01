package cn.tedu.nybike.service;

import org.junit.Test;

import cn.tedu.nybike.pojo.Demo1VO;

public class StatusServiceTest {
    StatusService service = new StatusService();
    @Test
	public void findStatus() {
		Demo1VO vo = service.findStatus();
		System.out.println(vo);
	}
}
