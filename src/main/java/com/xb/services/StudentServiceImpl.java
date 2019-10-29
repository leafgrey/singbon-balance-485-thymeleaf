package com.xb.services;
import com.xb.domain.Student;
import com.xb.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
	@Resource
	private StudentMapper studentMapper;
	@Override
	public int deleteByPrimaryKey(Long id) {
		return studentMapper.deleteByPrimaryKey(id);
	}
	@Override
	public int insert(Student record) {
		return studentMapper.insert(record);
	}
	@Override
	public int insertSelective(Student record) {
		return studentMapper.insertSelective(record);
	}
	@Override
	public Student selectByPrimaryKey(Long id) {
		return studentMapper.selectByPrimaryKey(id);
	}
	@Override
	public int updateByPrimaryKeySelective(Student record) {
		return studentMapper.updateByPrimaryKeySelective(record);
	}
	@Override
	public int updateByPrimaryKey(Student record) {
		return studentMapper.updateByPrimaryKey(record);
	}
	@Override
	public int batchInsert(List<Student> list) {
		return studentMapper.batchInsert(list);
	}
	@Override
	public List<Student> selectAllStudentList() {
		return this.studentMapper.selectAllStudentList();
	}
}
