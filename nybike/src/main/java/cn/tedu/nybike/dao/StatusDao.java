package cn.tedu.nybike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import cn.tedu.nybike.pojo.Demo1DO;
import cn.tedu.nybike.pojo.Demo2DO;
import cn.tedu.nybike.util.DBUtils;

public class StatusDao {
	public List<Demo2DO> listStatusById(int sid){
		String sql = "select data_timestamp,num_bikes_available,num_docks_available from tb_status_915 where station_id = ? order by data_timestamp";
		List<Demo2DO> list = new LinkedList<Demo2DO>();
		try(Connection conn = DBUtils.getConn();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, sid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				long time = rs.getLong("data_timestamp");
				int nba = rs.getInt("num_bikes_available");
				int nda = rs.getInt("num_docks_available");
				Demo2DO dDO = new Demo2DO(time, nba, nda);
				list.add(dDO);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
    /**
     * 查询所有站点的id和nba的方法
     * @return 封装了站点id和nba的集合
     */
	public List<Demo1DO> listStatus(){
		String sql = "select sid,nba from tb_status order by nba";
		List<Demo1DO> list = new LinkedList<Demo1DO>();
		try(Connection conn = DBUtils.getConn();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int sid = rs.getInt("sid");
				int nba = rs.getInt("nba");
				Demo1DO dDO = new Demo1DO(sid, nba);
				list.add(dDO);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
