package cn.tedu.nybike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import cn.tedu.nybike.pojo.CustomDO;
import cn.tedu.nybike.pojo.Demo3DO;
import cn.tedu.nybike.pojo.Demo4DO;
import cn.tedu.nybike.pojo.Demo5DO;
import cn.tedu.nybike.pojo.WeatherDO;
import cn.tedu.nybike.pojo.newDemo3Do;
import cn.tedu.nybike.util.DBUtils;

public class TripDAO {
	
	public List<newDemo3Do> listHourCount2(){
		List<newDemo3Do> list=new LinkedList<newDemo3Do>();
		String sql="select * from tb_hc_0601 order by hour";
		try(Connection conn=DBUtils.getConn();
				PreparedStatement ps=conn.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int hour=rs.getInt("hour");
				int count=rs.getInt("c_count");
				newDemo3Do demo3Do = new newDemo3Do(hour,count);
				list.add(demo3Do);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Demo3DO> listHourCount1(){
		String sql = "select * from tb_hc_0601 order by hour;";
		List<Demo3DO> list = new LinkedList<Demo3DO>();	
		try(Connection conn = DBUtils.getConn();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int hours = rs.getInt("hour");
				int count = rs.getInt("c_count");
				Demo3DO dDO = new Demo3DO(hours, count);
				list.add(dDO);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Demo4DO> listHourDayCount(){
		String sql = "select * from tb_dhc_06;";
		List<Demo4DO> list = new LinkedList<Demo4DO>();	
		try(Connection conn = DBUtils.getConn();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int day = rs.getInt("day");
				int hours = rs.getInt("hour");
				int count = rs.getInt("dh_count");
				Demo4DO dDO = new Demo4DO(hours, day, count);
				list.add(dDO);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Demo5DO> hotPoint(){
		String sql = "select * from tb_mhot_06;";
		List<Demo5DO> list = new LinkedList<Demo5DO>();	
		try(Connection conn = DBUtils.getConn();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("s_id");
				double lat = rs.getDouble("s_lat");
				double lon = rs.getDouble("s_lon");
				int count = rs.getInt("c_count");
				Demo5DO dDO = new Demo5DO(id, lat, lon, count);
				list.add(dDO);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<WeatherDO> weatherDOList(){
		String sql = "select * from tb_wgdt_06;";
		List<WeatherDO> list = new LinkedList<WeatherDO>();	
		try(Connection conn = DBUtils.getConn();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String types = rs.getString("types");
				int gender = rs.getInt("gender");
				long duration = rs.getLong("tripduration");
				WeatherDO weatherDO = new WeatherDO(types, gender, duration);
				list.add(weatherDO);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Long> customAndSubs(){
		String sql = "select * from tb_utd_06 where usertype = 'Customer' order by day;";
		List<Long> list = new LinkedList<Long>();	
		try(Connection conn = DBUtils.getConn();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String usertype = rs.getString("usertype");
				int day = rs.getInt("day");
				long tripduration = rs.getLong("tripduration");
			    CustomDO customDO = new CustomDO(day, usertype, tripduration);
				list.add(tripduration);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Long> subAndSubs(){
		String sql = "select * from tb_utd_06 where usertype = 'Subscriber' order by day;";
		List<Long> list = new LinkedList<Long>();	
		try(Connection conn = DBUtils.getConn();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String usertype = rs.getString("usertype");
				int day = rs.getInt("day");
				long tripduration = rs.getLong("tripduration");
			    CustomDO customDO = new CustomDO(day, usertype, tripduration);
				list.add(tripduration);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
