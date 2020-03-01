package cn.tedu.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.tedu.nybike.util.DBUtils;
import cn.tedu.nybike.util.HttpUtil;

public class UploadData {

	public static void main(String[] args) {
		// 请求一条站点状态数据
				String statusUrl="https://gbfs.citibikenyc.com/gbfs/en/station_status.json";
				String statusData=HttpUtil.get(statusUrl);				
				// 解析数据
				JSONArray stations=JSON.parseObject(statusData).getJSONObject("data").getJSONArray("stations");
			    //若不知该开辟多大空间,应用LinkedList
				List<Item> list = new ArrayList<Item>(stations.size());
				for(Object obj:stations) {
					JSONObject jObj=(JSONObject)obj;
					// 获取每个站点的sid,nba,nda,计算abi
					int sid=jObj.getIntValue("station_id");
					int nba=jObj.getIntValue("num_bikes_available");
					int nda=jObj.getIntValue("num_docks_available");
					double abi=(nba+nda)==0?0:nba*1.0/(nba+nda);
					Item item = new Item(sid, nba, nda, abi);
					list.add(item);
				}
				
				// 从代码规范性的角度，不应该将JDBC的代码
				// 和JSON解析的代码混在一起
				// 解决方案：上面的散装数据应该封装起来
				String sql = "insert into tb_status values(?,?,?,?)";
				try(Connection conn = DBUtils.getConn();
						PreparedStatement ps = conn.prepareStatement(sql)){
					//开启事务
					conn.setAutoCommit(false);
					for(Item item : list) {
						//向ps中绑定参数
						ps.setInt(1, item.getSid());
						ps.setInt(2, item.getNba());
						ps.setInt(3, item.getNda());
						ps.setDouble(4, item.getAbi());
						//将语句添加到批中
						ps.addBatch();
					}
					//提交批
					ps.executeBatch();
					//提交事务
					conn.commit();
				}catch (Exception e) {
					e.printStackTrace();
				}
	}

}
