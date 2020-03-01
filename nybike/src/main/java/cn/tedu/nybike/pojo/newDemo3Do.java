package cn.tedu.nybike.pojo;

public class newDemo3Do {
	private Integer hour;
	private Integer count;
	@Override
	public String toString() {
		return "Demo3Do [hour=" + hour + ", count=" + count + "]";
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
	public newDemo3Do() {
		super();
		// TODO Auto-generated constructor stub
	}
	public newDemo3Do(Integer hour, Integer count) {
		super();
		this.hour = hour;
		this.count = count;
	}
}
