package com.maike.myblog.utils;

import lombok.Data;

/**
 * @projectname BeautyDress
 * @author GEEKCJJ
 * @date 2019年8月17日 上午10:51:06
 * @description:
 *
 */
@Data
public class ResultSMS {
	private String returnstatus;
	private String message;
	private String remainpoint;
	private String taskID;
	private String successCounts;
}
