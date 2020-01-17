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
@ApiModel(value = "UserRolePermission对象", description = "")
public class UserRolePermission implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.INPUT)
	private String id;

	@ApiModelProperty(value = "用户角色表的id")
	@TableField("users_role_id")
	private Integer usersRoleId;

	@ApiModelProperty(value = "用户角色的权限表id")
	@TableField("role_permission_id")
	private String rolePermissionId;

}
