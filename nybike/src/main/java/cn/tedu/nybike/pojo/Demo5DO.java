package cn.tedu.nybike.pojo;

public class Demo5DO {
    private Integer id;
    private Double lat;
    private Double lon;
    private Integer count;
	public Demo5DO() {
	}
	public Demo5DO(Integer id, Double lat, Double lon, Integer count) {
		this.id = id;
		this.lat = lat;
		this.lon = lon;
		this.count = count;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Demo5DO [id=" + id + ", lat=" + lat + ", lon=" + lon + ", count=" + count + "]";
	}
	
    
}
