package cn.tedu.nybike.pojo;

import java.util.List;

public class newDemo3Vo {
	private List<Integer> hours;
	private List<Integer> counts;
	public newDemo3Vo(List<Integer> hours, List<Integer> counts) {
		super();
		this.hours = hours;
		this.counts = counts;
	}
	public newDemo3Vo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "newDemo3Vo [hours=" + hours + ", counts=" + counts + "]";
	}
	public List<Integer> getHours() {
		return hours;
	}
	public void setHours(List<Integer> hours) {
		this.hours = hours;
	}
	public List<Integer> getCounts() {
		return counts;
	}
	public void setCounts(List<Integer> counts) {
		this.counts = counts;
	}
}
