package com.maike.myblog.utils;

import java.io.Serializable;

import com.maike.myblog.enums.ResultEnum;

import lombok.Data;

/**
 * @projectname BeautyDress
 * @author GEEKCJJ
 * @date 2019年8月15日 下午7:49:18
 * @description:
 *
 */
@Data
public class Result implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -469044170063307887L;
	/**
	 * 错误码，对应{@link ErrorCode}，表示一种错误类型 如果是成功，则code为200
	 */
	private int code;
	/**
	 * 对错误的具体解释
	 */
	private String msg;
	/**
	 * 返回的结果包装在value中，value可以是单个对象
	 */
	private Object data;
	/**
	 * 数据的条数
	 */
	private String count;

	public Result() {

	}

	/** 成功且带数据 **/
	public static Result success(Object object) {
		Result result = new Result();
		result.setCode(ResultEnum.SUCCESS.getCode());
		result.setMsg(ResultEnum.SUCCESS.getMsg());
		result.setData(object);
		return result;
	}

	/** 成功且带数据和数量适用于layui表格数据 **/
	public static Result success(Object object, String count) {
		Result result = new Result();
		result.setCode(0);
		result.setMsg(ResultEnum.SUCCESS.getMsg());
		result.setData(object);
		result.setCount(count);
		return result;
	}

	/** 成功但不带数据 **/
	public static Result success() {
		return success(true);
	}

	/** 失败 **/
	public static Result error(Integer code, String msg) {
		Result result = new Result();
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}

	/** 失败只带数据 **/
	public static Result error(String msg) {
		Result result = new Result();
		result.setMsg(msg);
		return result;
	}

	public static Result error(MyException myExceptionEnum) {
		return error(myExceptionEnum.getStatusCode(), myExceptionEnum.getMessage());
	}
}
