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
 * @since 2019-09-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="BlogUser对象", description="")
public class BlogUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "用户头像")
    @TableField("user_pic")
    private String userPic;

    @ApiModelProperty(value = "登录用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty(value = "显示给别人的昵称")
    @TableField("nickname")
    private String nickname;

    @ApiModelProperty(value = "个人信息中的邮件")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "个人信息的手机号")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "个人简介")
    @TableField("personalintroduction")
    private String personalintroduction;

    @ApiModelProperty(value = "个人签名")
    @TableField("personalizedsignature")
    private String personalizedsignature;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "我的其他网站链接")
    @TableField("myotherlink")
    private String myotherlink;
    
    @ApiModelProperty(value = "出生日期")
    @TableField("birth_time")
    private String birthTime;
    
    @ApiModelProperty(value = "性别:0为女生,1位男生")
    @TableField("user_gender")
    private String userGender;
    
    @ApiModelProperty(value = "职业描述")
    @TableField("in_industry")
    private String inIndustry;
    
    @ApiModelProperty(value = "所在城市")
    @TableField("in_city")
    private String inCity;


}
