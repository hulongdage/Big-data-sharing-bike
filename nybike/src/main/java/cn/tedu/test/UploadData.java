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
		// ����һ��վ��״̬����
				String statusUrl="https://gbfs.citibikenyc.com/gbfs/en/station_status.json";
				String statusData=HttpUtil.get(statusUrl);				
				// ��������
				JSONArray stations=JSON.parseObject(statusData).getJSONObject("data").getJSONArray("stations");
			    //����֪�ÿ��ٶ��ռ�,Ӧ��LinkedList
				List<Item> list = new ArrayList<Item>(stations.size());
				for(Object obj:stations) {
					JSONObject jObj=(JSONObject)obj;
					// ��ȡÿ��վ���sid,nba,nda,����abi
					int sid=jObj.getIntValue("station_id");
					int nba=jObj.getIntValue("num_bikes_available");
					int nda=jObj.getIntValue("num_docks_available");
					double abi=(nba+nda)==0?0:nba*1.0/(nba+nda);
					Item item = new Item(sid, nba, nda, abi);
					list.add(item);
				}
				
				// �Ӵ���淶�ԵĽǶȣ���Ӧ�ý�JDBC�Ĵ���
				// ��JSON�����Ĵ������һ��
				// ��������������ɢװ����Ӧ�÷�װ����
				String sql = "insert into tb_status values(?,?,?,?)";
				try(Connection conn = DBUtils.getConn();
						PreparedStatement ps = conn.prepareStatement(sql)){
					//��������
					conn.setAutoCommit(false);
					for(Item item : list) {
						//��ps�а󶨲���
						ps.setInt(1, item.getSid());
						ps.setInt(2, item.getNba());
						ps.setInt(3, item.getNda());
						ps.setDouble(4, item.getAbi());
						//�������ӵ�����
						ps.addBatch();
					}
					//�ύ��
					ps.executeBatch();
					//�ύ����
					conn.commit();
				}catch (Exception e) {
					e.printStackTrace();
				}
	}

}
