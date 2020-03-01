package cn.tedu.nybike.pojo;

import java.util.List;

public class Demo2VO {

	private List<String> times; //HH:mm
	private List<Integer> nbas;
	private List<Integer> ndas;
	public Demo2VO() {
	}
	public Demo2VO(List<String> times, List<Integer> nbas, List<Integer> ndas) {
		this.times = times;
		this.nbas = nbas;
		this.ndas = ndas;
	}
	public List<String> getTimes() {
		return times;
	}
	public void setTimes(List<String> times) {
		this.times = times;
	}
	public List<Integer> getNbas() {
		return nbas;
	}
	public void setNbas(List<Integer> nbas) {
		this.nbas = nbas;
	}
	public List<Integer> getNdas() {
		return ndas;
	}
	public void setNdas(List<Integer> ndas) {
		this.ndas = ndas;
	}
	@Override
	public String toString() {
		return "Demo2VO [times=" + times + ", nbas=" + nbas + ", ndas=" + ndas + "]";
	}
	
}
