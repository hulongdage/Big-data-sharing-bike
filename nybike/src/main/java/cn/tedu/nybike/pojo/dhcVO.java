package cn.tedu.nybike.pojo;

import java.util.List;

public class dhcVO {
  
	private List<Demo4DO> demo4List;

	public dhcVO() {
	}

	public dhcVO(List<Demo4DO> demo4List) {
		this.demo4List = demo4List;
	}

	public List<Demo4DO> getDemo4List() {
		return demo4List;
	}

	public void setDemo4List(List<Demo4DO> demo4List) {
		this.demo4List = demo4List;
	}

	@Override
	public String toString() {
		return "dhcVO [demo4List=" + demo4List + "]";
	}
    
}
