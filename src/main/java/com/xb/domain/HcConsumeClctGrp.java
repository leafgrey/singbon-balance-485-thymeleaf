package com.xb.domain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@ApiModel(value = "HcConsumeClctGrp")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HcConsumeClctGrp implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "null")
	private String adate;
	@ApiModelProperty(value = "null")
	private Integer grpno1;
	@ApiModelProperty(value = "null")
	private Integer server;
	@ApiModelProperty(value = "null")
	private Object amount1;
	@ApiModelProperty(value = "null")
	private Long rvsamount1;
	@ApiModelProperty(value = "null")
	private Object amount2;
	@ApiModelProperty(value = "null")
	private Long rvsamount2;
	@ApiModelProperty(value = "null")
	private Object amount3;
	@ApiModelProperty(value = "null")
	private Long rvsamount3;
	@ApiModelProperty(value = "null")
	private Object amount4;
	@ApiModelProperty(value = "null")
	private Long rvsamount4;
	@ApiModelProperty(value = "null")
	private Object amountother;
	@ApiModelProperty(value = "null")
	private Long rvsamountother;
	@ApiModelProperty(value = "null")
	private Object amountallday;
	@ApiModelProperty(value = "null")
	private Long rvsamountallday;
	@ApiModelProperty(value = "null")
	private String groupname;
}