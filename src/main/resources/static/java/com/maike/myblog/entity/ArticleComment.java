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
 * @since 2019-10-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ArticleComment对象", description="")
public class ArticleComment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "发表评论的用户ID")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty(value = "被评论的用户ID")
    @TableField("to_user_id")
    private Integer toUserId;

    @ApiModelProperty(value = "评论内容")
    @TableField("comment_content")
    private String commentContent;

    @ApiModelProperty(value = "点赞数量")
    @TableField("thumb_count")
    private String thumbCount;

    @ApiModelProperty(value = "文章ID")
    @TableField("article_id")
    private String articleId;

    @ApiModelProperty(value = "文章类型,与文章ID搭配使用,判断评论属于哪一种文章")
    @TableField("article_type")
    private String articleType;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private String createTime;

}
