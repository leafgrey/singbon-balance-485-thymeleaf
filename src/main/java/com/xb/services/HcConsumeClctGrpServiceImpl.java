package com.xb.services;
import com.xb.domain.HcConsumeClctGrp;
import com.xb.mapper.HcConsumeClctGrpMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
/**
 * @author zch
 */
@Service
public class HcConsumeClctGrpServiceImpl implements HcConsumeClctGrpService {
	@Resource
	private HcConsumeClctGrpMapper hcConsumeClctGrpMapper;
	@Override
	public int deleteByPrimaryKey(String adate, Integer grpno1) {
		return hcConsumeClctGrpMapper.deleteByPrimaryKey(adate, grpno1);
	}
	@Override
	public int insert(HcConsumeClctGrp record) {
		return hcConsumeClctGrpMapper.insert(record);
	}
	@Override
	public int insertSelective(HcConsumeClctGrp record) {
		return hcConsumeClctGrpMapper.insertSelective(record);
	}
	@Override
	public HcConsumeClctGrp selectByPrimaryKey(String adate, Integer grpno1) {
		return hcConsumeClctGrpMapper.selectByPrimaryKey(adate, grpno1);
	}
	@Override
	public int updateByPrimaryKeySelective(HcConsumeClctGrp record) {
		return hcConsumeClctGrpMapper.updateByPrimaryKeySelective(record);
	}
	@Override
	public int updateByPrimaryKey(HcConsumeClctGrp record) {
		return hcConsumeClctGrpMapper.updateByPrimaryKey(record);
	}
	@Override
	public int batchInsert(List<HcConsumeClctGrp> list) {
		return hcConsumeClctGrpMapper.batchInsert(list);
	}
	@Override
	public List<Map<String, String>> selectDeptDayTurnover(String bgDate, String edDate) {
		return hcConsumeClctGrpMapper.selectDeptDayTurnover(bgDate,edDate);
	}
	@Override
	public List<Map<String, String>> selectDeptDayTurnoverSummary(String bgDate, String edDate) {
		return hcConsumeClctGrpMapper.selectDeptDayTurnoverSummary(bgDate,edDate);
	}
	@Override
	public List<Map<String, String>> selectDeptDayTurnoverDetail(String bgDate, String edDate) {
		return hcConsumeClctGrpMapper.selectDeptDayTurnoverDetail(bgDate,edDate);
	}
}
