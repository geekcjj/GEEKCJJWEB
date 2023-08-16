package com.maike.myblog.token;

import java.util.Date;

import com.maike.myblog.utils.DateUtil;

/** 
 * @ClassName: CustomerToken 
 * @Description: 客户令牌映射实体
 * @author: WeiZheng
 * @date: 2018年9月18日 上午10:42:45  
 */
public class CustomerToken {

	/**
	 * 客户编号
	 */
	private Integer customerId;
	/**
	 * 客户名称
	 */
	private String customerName;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 过期时间 令牌持续时间
	 */
	private Date expiredTime;
	
	public CustomerToken() {
	}
	
	/**
	 * @param customerId 客户编号
	 * @param customerName 客户账户
	 */
	public CustomerToken(Integer customerId, String customerName) {
		this.customerId = customerId;
		this.customerName = customerName;
		Date now = new Date();
		this.createTime = now;
		this.expiredTime = DateUtil.getExpiredTime(now, 1);
	}

	/**
	 * @return the customerId
	 */
	public Integer getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the expiredTime
	 */
	public Date getExpiredTime() {
		return expiredTime;
	}
	/**
	 * @param expiredTime the expiredTime to set
	 */
	public void setExpiredTime(Date expiredTime) {
		this.expiredTime = expiredTime;
	}
	
}
