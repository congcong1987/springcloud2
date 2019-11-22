package com.itcast.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "com.itcast.auth.dtoUserDto", description = "用户信息") 
public class UserDto {
	@ApiModelProperty(value="ID")
	private String id;
	
	@ApiModelProperty(value="名称")
	private String name;

	
	
	
}
