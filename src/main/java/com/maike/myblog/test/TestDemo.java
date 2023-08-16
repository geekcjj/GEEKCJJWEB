package com.maike.myblog.test;

import java.util.ArrayList;
import java.util.List;

import com.maike.myblog.utils.Result;

/**
 * @projectname GEEKCJJWeb
 * @author GEEKCJJ
 * @date 2019年10月21日 上午3:04:24
 * @description:
 *
 */
public class TestDemo {
	public static void main(String[] args) {
		List<String> strList = new ArrayList<String>();
		strList.add("12");
		strList.add("45");
		strList.add("78");
		strList.add("34");
		// String str2[]= {"12","34","56","78"};
//		for(String str:str2)
//		if(str.equals("12")) {
//			System.out.println("chenggogn");
//		}else {
//			System.out.println("shiabi");
//		}
		if (strList.contains("45")) {
			System.out.println("hide");
		}
	}
}
