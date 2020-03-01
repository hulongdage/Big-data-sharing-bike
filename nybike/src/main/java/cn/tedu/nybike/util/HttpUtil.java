package cn.tedu.nybike.util;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
	
	/**
	 * ����GET���󣬲�������Ӧ���ݵķ���
	 * @param urlStr �����url
	 * @return ��Ӧ����
	 */
	public static String get(String urlStr){
        String message="";
        try {
            URL url=new URL(urlStr);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5*1000);
            connection.connect();
            InputStream inputStream=connection.getInputStream();
            byte[] data=new byte[1024*512];// 512kb����ռ�
            StringBuffer sb=new StringBuffer();
            int length=0;
            while ((length=inputStream.read(data))!=-1){
                String s=new String(data,0,length);
                sb.append(s);
            }
            message=sb.toString();
            inputStream.close();
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }
	
	public static void main(String[] args) {
		String url="https://gbfs.citibikenyc.com/gbfs/en/station_status.json";
	
		String result=HttpUtil.get(url);
		
		System.out.println(result);
		System.out.println(result.length());
	}

}
