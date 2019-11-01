package com.xb.services;
import com.xb.domain.HcConsumeClctGrp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
public interface HcConsumeClctGrpService {
	int deleteByPrimaryKey(String adate, Integer grpno1);
	int insert(HcConsumeClctGrp record);
	int insertSelective(HcConsumeClctGrp record);
	HcConsumeClctGrp selectByPrimaryKey(String adate, Integer grpno1);
	int updateByPrimaryKeySelective(HcConsumeClctGrp record);
	int updateByPrimaryKey(HcConsumeClctGrp record);
	int batchInsert(List<HcConsumeClctGrp> list);
	List<Map<String,String>> selectDeptDayTurnover(String bgDate,String edDate,String groupname);
	List<Map<String,String>> selectDeptDayTurnoverSummary(String bgDate,String edDate,String groupname);
	List<Map<String,String>> selectDeptDayTurnoverDetail(String bgDate,String edDate,String groupname);
	List<Map<String,String>> selectMaxMinBusinessVolume(String bgDate,String edDate,String groupname);
}
