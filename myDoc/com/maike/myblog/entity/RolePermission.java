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
@ApiModel(value="RolePermission对象", description="")
public class RolePermission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "权限名称")
    @TableField("permission_name")
    private String permissionName;

    @ApiModelProperty(value = "权限的地址URL")
    @TableField("permission_url")
    private String permissionUrl;

    @ApiModelProperty(value = "权限的类型:button或menu")
    @TableField("permission_type")
    private String permissionType;

    @ApiModelProperty(value = "权限的操作:add、")
    @TableField("permission_operate")
    private String permissionOperate;

    @ApiModelProperty(value = "权限父id,是button就为0,是menu就为自然数")
    @TableField("parent_id")
    private Integer parentId;

    @ApiModelProperty(value = "权限子id,是button为父id的值,是menu则为0")
    @TableField("parent_child_id")
    private Integer parentChildId;


}
