package cn.tedu.nybike.pojo;

public class CustomDO {
    private Integer day;
    private String usertype;
    private Long tripduration;
	public CustomDO() {
	}
	public CustomDO(Integer day, String usertype, Long tripduration) {
		this.day = day;
		this.usertype = usertype;
		this.tripduration = tripduration;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public Long getTripduration() {
		return tripduration;
	}
	public void setTripduration(Long tripduration) {
		this.tripduration = tripduration;
	}
	@Override
	public String toString() {
		return "CustomDO [day=" + day + ", usertype=" + usertype + ", tripduration=" + tripduration + "]";
	}   
}
