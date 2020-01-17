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
 * @since 2019-10-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="IndexGallery对象", description="")
public class IndexGallery implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    @ApiModelProperty(value = "滑动图片的url,不仅是图片也可以是视频等其他广告等图片资源")
    @TableField("slider_img")
    private String sliderImg;

    @ApiModelProperty(value = "图片的描述")
    @TableField("img_description")
    private String imgDescription;

    @ApiModelProperty(value = "图片要链接饿地址,可以是网站内的一个url,也可以是外部网站的链接")
    @TableField("img_link")
    private String imgLink;

    @ApiModelProperty(value = "是否是广告")
    @TableField("is_advertise")
    private String isAdvertise;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;


}
