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
 * @since 2019-09-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="LeaveWords对象", description="")
public class LeaveWords implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "用户留言的昵称")
    @TableField("nick_name")
    private String nickName;

    @ApiModelProperty(value = "用户的email")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "用户留言的标题")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "用户留言的内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "留言的类型")
    @TableField("lw_type")
    private String lwType;


}
