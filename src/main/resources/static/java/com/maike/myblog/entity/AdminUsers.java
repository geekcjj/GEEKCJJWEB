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
 * @since 2019-09-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="AdminUsers对象", description="")
public class AdminUsers implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "用户头像地址")
    @TableField("user_pic")
    private String userPic;

    @ApiModelProperty(value = "登录用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty(value = "登录密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "显示给别人的昵称")
    @TableField("nickname")
    private String nickname;

    @ApiModelProperty(value = "管理员邮件")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "管理员手机号")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "管理员简介")
    @TableField("personalintroduction")
    private String personalintroduction;

    @ApiModelProperty(value = "管理员签名")
    @TableField("personalizedsignature")
    private String personalizedsignature;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "我的其他网站链接")
    @TableField("myotherlink")
    private String myotherlink;


}
