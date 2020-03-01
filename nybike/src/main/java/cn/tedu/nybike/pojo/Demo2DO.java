package cn.tedu.nybike.pojo;

public class Demo2DO {

	private Long time;
	private Integer nba;
	private Integer nda;
	public Demo2DO() {
	}
	public Demo2DO(Long time, Integer nba, Integer nda) {
		this.time = time;
		this.nba = nba;
		this.nda = nda;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public Integer getNba() {
		return nba;
	}
	public void setNba(Integer nba) {
		this.nba = nba;
	}
	public Integer getNda() {
		return nda;
	}
	public void setNda(Integer nda) {
		this.nda = nda;
	}
	@Override
	public String toString() {
		return "Demo2DO [time=" + time + ", nba=" + nba + ", nda=" + nda + "]";
	}
	
}
