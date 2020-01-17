package com.maike.myblog.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GenerateIdUtil {
	// 格式化的时间字符串
	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

	// 获取当前时间年月日时分秒毫秒字符串
	private static String getNowDateStr() {
		return sdf.format(new Date());
	}

	// 记录上一次的时间，用来判断是否需要递增全局数
	private static String now = null;
	// 全局自增数
	private static int count = 0;

	// 每毫秒秒最多生成多少订单（最好是像9999这种准备进位的值）
	private static final int total = 99999;

	/*
	 * 生成一个订单号
	 */
	public static String bornCount(String param) {
//			String param="0005"; // 首先查询出那个counter值
		if (param == null) {
			param = "100000";
		}
		Random random = new Random();
		int s = random.nextInt(Integer.parseInt(param));
		++s;
		s = (s == 100000 ? 1 : s); // 这里将规定最大数字设定为小于1000 如果对生成的数字没有特定要求可以注释掉 我这里没有要求所以进行了注释
		String reslut = String.format("%05d", s);// s>=10?(s>=100?s+"":"0"+s):"00"+s; // 计算 转型
		String datastr = getNowDateStr();
		System.out.println(String.format("%05d", s)); // 然后存到 数据库！ 已测试哈！试试看！
		return datastr + reslut;
	}

	public synchronized static String createCount() {
//		if(param==null){
//            param = "100000";
//        }
		String datastr = getNowDateStr();
		if (datastr.equals(now)) {
			count++;// 自增
		} else {
			count = 1;
			now = datastr;
		}
		// Random random=new Random();
		// int num=Integer.parseInt(param);
		// Integer randomNum=random.nextInt(num);
		if (count >= total) {
			count = 0;
		}
		String resultNum = String.format("%05d", count);
		// String reslut=s>=10?(s>=100?(s>=1000?s+"":"0"+s):"00"+s):"000"+s; // 计算 转型
		// (s>=10000?s+"":"0"+s)
		return datastr + resultNum;
	}

	/**
	 * 生成规则设备编号:设备类型+五位编号（从1开始，不够前补0）
	 * 
	 * @param equipmentType 设备类型
	 * @param equipmentNo   最新设备编号
	 * @return
	 */
	public synchronized String getNewEquipmentNo(String equipmentType, String equipmentNo) {
		String newEquipmentNo = "0001";
		String datastr = getNowDateStr();
		if (equipmentNo != null && !equipmentNo.isEmpty()) {
			int newEquipment = Integer.parseInt(equipmentNo) + 1;
			newEquipmentNo = String.format("%04d", newEquipment);
		}
		return datastr + newEquipmentNo;
	}

	public static void main(String[] args) {
		System.out.println(getNowDateStr());
		System.out.println(bornCount(null));
		System.out.println(createCount());
		System.out.println(createCount());
	}
}
