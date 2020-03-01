package cn.tedu.nybike.pojo;

import java.util.List;

public class Demo1VO {
    private List<Integer> xData;  //sid的集合
    private List<Integer> yData;  //nba的集合
	public Demo1VO() {	
	}
	public Demo1VO(List<Integer> xData, List<Integer> yData) {
		this.xData = xData;
		this.yData = yData;
	}
	public List<Integer> getxData() {
		return xData;
	}
	public void setxData(List<Integer> xData) {
		this.xData = xData;
	}
	public List<Integer> getyData() {
		return yData;
	}
	public void setyData(List<Integer> yData) {
		this.yData = yData;
	}
	@Override
	public String toString() {
		return "Demo1VO [xData=" + xData + ", yData=" + yData + "]";
	}
   
}
