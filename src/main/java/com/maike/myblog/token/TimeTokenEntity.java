package com.maike.myblog.token;

import java.util.Date;

/** 
 * @ClassName: TimeTokenEntity 
 * @Description: 时效令牌登录信息实体
 * @author: WeiZheng
 * @date: 2018年8月22日 上午11:25:26  
 */
public class TimeTokenEntity {

	/**
	 * 用户编号
	 */
	private Integer id;
	/**
	 * 分销商编号
	 */
	private Integer sellerId;
	/**
	 * 账户名称
	 */
	private String account;
	/**
	 * 时效令牌
	 */
	private String token;
	/**
	 * 信息创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间 登录 授权 会刷新
	 */
	private Date updateTime;
	/**
	 * 过期时间 登录时间+1
	 */
	private Date expiredTime;
	/**
	 * 权限(0 z正常员工 1 管理员 经理)
	 */
	private String authority;
	
	public TimeTokenEntity() {
	}
	
	/**
	 * @param id  用户编号
	 * @param sellerId  分销商编号
	 * @param account 账户名称
	 */
	public TimeTokenEntity(Integer id, Integer sellerId, String account) {
		this.id = id;
		this.sellerId = sellerId;
		this.account = account;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the sellerId
	 */
	public Integer getSellerId() {
		return sellerId;
	}
	/**
	 * @param sellerId the sellerId to set
	 */
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
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
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
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

	/**
	 * @return the authority
	 */
	public String getAuthority() {
		return authority;
	}

	/**
	 * @param authority the authority to set
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "TimeTokenEntity [id=" + id + ", sellerId=" + sellerId + ", account=" + account + ", token=" + token
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + ", expiredTime=" + expiredTime
				+ ", authority=" + authority + "]";
	}
}
