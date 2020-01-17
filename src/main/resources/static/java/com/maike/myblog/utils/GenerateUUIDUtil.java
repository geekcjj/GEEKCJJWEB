package com.maike.myblog.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.velocity.runtime.parser.node.MathUtils;

public class GenerateUUIDUtil {
	private static int totalCount = 0;
	private static int customerID;
	private static String middle = "";
//	public IdCounterUtil(){
//		++totalCount;
//		customerID = totalCount;
//		System.out.println("增加一个");
//	}
//	public static int getCustomerID() {
//	DecimalFormat decimalFormat = new DecimalFormat("00000000");
//	int count=Integer.parseInt(decimalFormat.format(customerID));
//	return count;
//	}
	/*
	 * @Desccription 生成不带 - 的uuid
	*/
	public static String getUuid(){
		// 去掉"-"符号   
//        String temp = str.substring(0, 8) +str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) +str.substring(24);   
//        returnstr+","+temp;
	    return UUID.randomUUID().toString().replace("-", "");
	}
	public static String timeMillisID()
	{
		Random r=new Random();
		        //如生成的随机位数不足6位则自动加零补充
		DecimalFormat g=new DecimalFormat("1000000");
		        //返回时间增量+随机数的序列
		return String.format("%s%s",System.currentTimeMillis(),g.format(r.nextInt(1000000)));
	}
	private static AtomicInteger count = new AtomicInteger(0);
	// 格式化的时间字符串
    private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    // 获取当前时间年月日时分秒毫秒字符串
    private static String getNowDateStr() {
        return sdf.format(new Date());
    }
    //private static String now=null;
    /**
     * 传入相应的前缀生成自增的ID
     * 
     * @param groupID 前缀
     * @param end 上一次结束的ID编号
     * @return 生成自增的ID
     */
    public static String getQualityNum(String groupID, int end) {
        //count.set(end);
        //count.incrementAndGet();
        Integer i = count.getAndIncrement();
        //获取当前的年
        String getNowDateStr = getNowDateStr();
        //将传入的前缀与项目部以及年拼接在以一起
        String format = groupID+getNowDateStr;
        String strNum = 100000+""+ i;
        //将1截取下来得到剩余的
        String substring = strNum.substring(1);
        //进行拼接并返回
        return format+substring;
    }
	/**
     * 以毫秒做基础计数, 返回唯一有序增长ID, 有几率出现线程并发
     * <pre>System.currentTimeMillis()</pre>
     * <pre>
     *  线程数量:   100
     *  执行次数:   1000
     *  平均耗时:   206 ms
     *  数组长度:   100000
     *  Map Size:   99992 
     * </pre>
     * @return  ID长度32位
     */
    public static String getIncreaseIdByCurrentTimeMillis(){
    	//2. 公式: 创建出Random类型的变量
    	Random ran = new Random();
    	// 3. 变量. 调用Random类中的功能,产生随机数
    	// Random类中的,产生随机数的功能
    	int i = ran.nextInt(100000000);
        return  System.currentTimeMillis()+                                             //时间戳-14位
                middle+                                                                 //标志-8位
                MathUtils.add(Thread.currentThread().hashCode(), 3)+      //3位线程标志
                i;                                    //随机8位数
    }
	public static void main(String[] args) {
		System.out.println(getIncreaseIdByCurrentTimeMillis());
		System.out.println(getUuid());
		System.out.println(timeMillisID());
		System.out.println(getQualityNum("rider",0));
		System.out.println(new Random().nextInt(1000000));
	}
}
