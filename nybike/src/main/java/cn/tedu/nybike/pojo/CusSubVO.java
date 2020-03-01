package cn.tedu.nybike.pojo;

import java.util.List;

public class CusSubVO {
    private List<Long> cusList;
    private List<Long> subList;
	public CusSubVO() {
	}
	public CusSubVO(List<Long> cusList, List<Long> subList) {
		this.cusList = cusList;
		this.subList = subList;
	}
	public List<Long> getCusList() {
		return cusList;
	}
	public void setCusList(List<Long> cusList) {
		this.cusList = cusList;
	}
	public List<Long> getSubList() {
		return subList;
	}
	public void setSubList(List<Long> subList) {
		this.subList = subList;
	}
	@Override
	public String toString() {
		return "CusSubVO [cusList=" + cusList + ", subList=" + subList + "]";
	}
	
}
