package com.xb.services;
import com.xb.domain.Student;

import java.util.List;
public interface StudentService {
	int deleteByPrimaryKey(Long id);
	int insert(Student record);
	int insertSelective(Student record);
	Student selectByPrimaryKey(Long id);
	int updateByPrimaryKeySelective(Student record);
	int updateByPrimaryKey(Student record);
	int batchInsert(List<Student> list);
	List<Student> selectAllStudentList();
}
