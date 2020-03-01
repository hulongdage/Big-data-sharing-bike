package cn.tedu.nybike.pojo;

public class WeatherDO {
    private String types;
    private Integer gender; //1ÄÐ
    private Long duration;
	public WeatherDO() {
	}
	public WeatherDO(String types, Integer gender, Long duration) {
		this.types = types;
		this.gender = gender;
		this.duration = duration;
	}
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "WeatherDO [types=" + types + ", gender=" + gender + ", duration=" + duration + "]";
	}
	
	
    
}
