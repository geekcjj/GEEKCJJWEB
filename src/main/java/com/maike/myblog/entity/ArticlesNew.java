package com.maike.myblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@ApiModel(value = "ArticlesNew对象", description = "")
public class ArticlesNew implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.INPUT)
	private String id;

	@ApiModelProperty(value = "作者名称")
	@TableField("author_name")
	private String authorName;

	@ApiModelProperty(value = "原作者")
	@TableField("original_author")
	private String originalAuthor;

	@ApiModelProperty(value = "文章标题")
	@TableField("title")
	private String title;

	@ApiModelProperty(value = "文章描述,用于在列表展示页的显示")
	@TableField("description")
	private String description;

	@ApiModelProperty(value = "文章内容")
	@TableField("content")
	private String content;

	@ApiModelProperty(value = "文章内容文件地址,留作之后升级用")
	@TableField("content_url")
	private String contentUrl;

	@ApiModelProperty(value = "文章浏览量")
	@TableField("browse_count")
	private Integer browseCount;

	@ApiModelProperty(value = "文章种类")
	@TableField("category_id")
	private Integer categoryId;

	@ApiModelProperty(value = "文章链接地址")
	@TableField("article_url")
	private String articleUrl;

	@ApiModelProperty(value = "点赞数")
	@TableField("likes")
	private Integer likes;

	@ApiModelProperty(value = "文章创建时间")
	@TableField("create_time")
	private LocalDateTime createTime;

	@ApiModelProperty(value = "上一篇文章ID")
	@TableField("previous_article_id")
	private String previousArticleId;

	@ApiModelProperty(value = "下一篇文章ID")
	@TableField("next_article_id")
	private String nextArticleId;

	@ApiModelProperty(value = "文章摘要的图片")
	@TableField("article_img")
	private String articleImg;

}
