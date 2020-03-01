package cn.tedu.nybike.pojo;

public class Demo1DO {
    private Integer sid;
    private Integer nba;
       
	public Demo1DO() {		
	}

	public Demo1DO(Integer sid, Integer nba) {		
		this.sid = sid;
		this.nba = nba;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getNba() {
		return nba;
	}

	public void setNba(Integer nba) {
		this.nba = nba;
	}

	@Override
	public String toString() {
		return "Demo1DO [sid=" + sid + ", nba=" + nba + "]";
	}
	
       
}
