package cn.tedu.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class FastJsonDemo {
	public static void main(String[] args) {
		String str = "{\"key1\":123,\"key2\":345}";
		//½âÎöjson×Ö·û´®
		JSONObject obj = JSON.parseObject(str);
		String str2 = obj.getString("key2");
		System.out.println(str2);
	}
}
