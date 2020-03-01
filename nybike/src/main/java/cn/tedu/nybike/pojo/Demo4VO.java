package cn.tedu.nybike.pojo;

import java.util.List;

public class Demo4VO {

	private List<Integer> hours;
	private List<Integer> counts;
	private List<Integer> days;
	public Demo4VO() {
	}
	public Demo4VO(List<Integer> hours, List<Integer> counts, List<Integer> days) {
		this.hours = hours;
		this.counts = counts;
		this.days = days;
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
	public List<Integer> getDays() {
		return days;
	}
	public void setDays(List<Integer> days) {
		this.days = days;
	}
	@Override
	public String toString() {
		return "Demo4VO [hours=" + hours + ", counts=" + counts + ", days=" + days + "]";
	}
	
}
