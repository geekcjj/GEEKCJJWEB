package com.maike.myblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author geekcjj
 * @since 2019-10-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "BlogUserPwd对象", description = "")
public class BlogUserPwd implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.INPUT)
	private String id;

	@ApiModelProperty(value = "博客用户id")
	@TableField("blog_user_id")
	private String blogUserId;

	@ApiModelProperty(value = "用户密码")
	@TableField("password")
	private String password;

}
