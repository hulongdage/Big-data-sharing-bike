package cn.tedu.nybike.pojo;

import java.util.List;

public class Demo3VO {

	private List<Integer> hours;
	private List<Integer> counts;
	public Demo3VO() {
	}
	public Demo3VO(List<Integer> hours, List<Integer> counts) {
		this.hours = hours;
		this.counts = counts;
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
	@Override
	public String toString() {
		return "Demo3VO [hours=" + hours + ", counts=" + counts + "]";
	}
	
}
