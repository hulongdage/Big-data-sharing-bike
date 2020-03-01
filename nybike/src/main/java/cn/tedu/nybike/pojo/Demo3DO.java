package cn.tedu.nybike.pojo;

public class Demo3DO {
    private Integer hour;
    private Integer count;
	public Demo3DO() {
	}
	public Demo3DO(Integer hour, Integer count) {
		this.hour = hour;
		this.count = count;
	}
	public Integer getHour() {
		return hour;
	}
	public void setHour(Integer hour) {
		this.hour = hour;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Demo3DO [hour=" + hour + ", count=" + count + "]";
	}
    
}
