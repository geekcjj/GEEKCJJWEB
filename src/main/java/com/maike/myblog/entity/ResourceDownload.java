package com.maike.myblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
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
@ApiModel(value = "ResourceDownload对象", description = "")
public class ResourceDownload implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableField("id")
	private String id;

	@ApiModelProperty(value = "上传作者昵称")
	@TableField("up_author")
	private String upAuthor;

	@ApiModelProperty(value = "资源的标题")
	@TableField("title")
	private String title;

	@ApiModelProperty(value = "资源的描述")
	@TableField("description")
	private String description;

	@ApiModelProperty(value = "资源的链接地址")
	@TableField("resource_add")
	private String resourceAdd;

	@ApiModelProperty(value = "资源上传时间")
	@TableField("create_time")
	private LocalDateTime createTime;

	@ApiModelProperty(value = "上传作者的ID")
	@TableField("up_user_id")
	private String upUserId;

}
