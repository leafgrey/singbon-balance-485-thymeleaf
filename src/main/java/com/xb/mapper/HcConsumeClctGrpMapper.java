package com.xb.mapper;
import com.xb.domain.HcConsumeClctGrp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
@Mapper
public interface HcConsumeClctGrpMapper {
	/**
	 * delete by primary key
	 * @param adate primaryKey
	 * @return deleteCount
	 */
	int deleteByPrimaryKey(@Param("adate") String adate, @Param("grpno1") Integer grpno1);
	/**
	 * insert record to table
	 * @param record the record
	 * @return insert count
	 */
	int insert(HcConsumeClctGrp record);
	/**
	 * insert record to table selective
	 * @param record the record
	 * @return insert count
	 */
	int insertSelective(HcConsumeClctGrp record);
	/**
	 * select by primary key
	 * @param adate primary key
	 * @return object by primary key
	 */
	HcConsumeClctGrp selectByPrimaryKey(@Param("adate") String adate, @Param("grpno1") Integer grpno1);
	/**
	 * update record
	 * @param record the updated record
	 * @return update count
	 */
	int updateByPrimaryKeySelective(HcConsumeClctGrp record);
	/**
	 * update record selective
	 * @param record the updated record
	 * @return update count
	 */
	int updateByPrimaryKey(HcConsumeClctGrp record);
	int batchInsert(@Param("list") List<HcConsumeClctGrp> list);
	/**
	 * selectDeptDayTurnoverDetail
	 * @param bgDate String
	 * @param edDate String
	 * @return List<Map<String,String>>
	 */
	List<Map<String,String>> selectDeptDayTurnoverDetail(@Param("bgDate") String bgDate, @Param("edDate") String edDate);
	/**
	 * selectDeptDayTurnoverSummary
	 * @param bgDate String
	 * @param edDate String
	 * @return List<Map<String,String>>
	 */
    List<Map<String,String>> selectDeptDayTurnoverSummary(@Param("bgDate") String bgDate, @Param("edDate") String edDate);

	List<Map<String,String>> selectDeptDayTurnover(@Param("bgDate") String bgDate, @Param("edDate") String edDate);
}