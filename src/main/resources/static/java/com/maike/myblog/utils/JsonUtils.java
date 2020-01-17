/**
 * 
 */
package com.maike.myblog.utils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
* @Package: com.maike.util JsonUtils.java
* @author GEEKCJJ
* @E-mail:geekcjj@gmail.com
* @version 创建时间：2019年4月17日 下午3:57:16
* 类说明
*/
/**
 * @author GEEKCJJ
 *
 */
public class JsonUtils {
	public static ObjectMapper objectMapper=new ObjectMapper();
	/**
	 * json字符转化成对象
	 * @param jsonStr
	 * @param classT
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object jsonToObject(String jsonStr,Class classT){
		/**
		 * 将字符串转化成Map对象
		 * 将Map对象转化成对象类型
		 */
		Map map = null;;
		Object object = null;
		try {
			map = objectMapper.readValue(jsonStr, Map.class);
			object = objectMapper.convertValue(map,classT);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return object;
	}
	/**
	 * 对象转化成json字符
	 * @param object
	 * @return
	 */
	public static String objectToJsonStr(Object object){
		String backMsg = null ;
		try {
			backMsg = objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return backMsg;
	}
	/**
	 * json 转化成列表
	 * @param arrayJson
	 * @param classT
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static List jsonToList(String arrayJson,Class classT){
		JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, classT);
		List lists = null ;
		try {
			lists = objectMapper.readValue(arrayJson, javaType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lists;
	}
}
