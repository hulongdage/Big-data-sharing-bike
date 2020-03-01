package cn.tedu.nybike.pojo;

public class Demo4DO {
    private Integer hour;
    private Integer day;
    private Integer count;
	public Demo4DO() {
	}
	public Demo4DO(Integer hour, Integer day, Integer count) {
		this.hour = hour;
		this.day = day;
		this.count = count;
	}
	public Integer getHour() {
		return hour;
	}
	public void setHour(Integer hour) {
		this.hour = hour;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Demo4DO [hour=" + hour + ", day=" + day + ", count=" + count + "]";
	}
	
    
}
