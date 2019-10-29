package com.xb.domain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@ApiModel(value = "com-xb-domain-Student")
@Data
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "null")
	private Long id;
	@ApiModelProperty(value = "null")
	private String name;
	@ApiModelProperty(value = "null")
	private String course;
	@ApiModelProperty(value = "null")
	private Date addtime;
}