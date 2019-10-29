package com.xb.mapper;
import com.xb.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface StudentMapper {
	/**
	 * delete by primary key
	 * @param id primaryKey
	 * @return deleteCount
	 */
	int deleteByPrimaryKey(Long id);
	/**
	 * insert record to table
	 * @param record the record
	 * @return insert count
	 */
	int insert(Student record);
	/**
	 * insert record to table selective
	 * @param record the record
	 * @return insert count
	 */
	int insertSelective(Student record);
	/**
	 * select by primary key
	 * @param id primary key
	 * @return object by primary key
	 */
	Student selectByPrimaryKey(Long id);
	/**
	 * update record
	 * @param record the updated record
	 * @return update count
	 */
	int updateByPrimaryKeySelective(Student record);
	/**
	 * update record selective
	 * @param record the updated record
	 * @return update count
	 */
	int updateByPrimaryKey(Student record);
	int batchInsert(@Param("list") List<Student> list);
	List<Student> selectAllStudentList();
}