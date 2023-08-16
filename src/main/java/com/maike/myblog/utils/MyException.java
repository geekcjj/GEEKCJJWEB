package com.maike.myblog.utils;

/**
 * @projectname ValidCode
 * @author GEEKCJJ
 * @date 2019年8月1日 上午9:51:07
 * @description:
 *
 */
public class MyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6121887837320846728L;
	// 状态码默认500
	private int statusCode = 500;

	public MyException(int statusCode, String message) {
		super(message);
		this.statusCode = statusCode;
	}

	public MyException(String message) {
		super(message);
	}

	public int getStatusCode() {
		return statusCode;
	}

}
