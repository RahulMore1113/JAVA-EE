package com.rahul.service;

import com.rahul.daofactory.StudentDaoFactory;
import com.rahul.dto.Student;
import com.rahul.persistence.IStudentDao;

public class StudentServiceImpl implements IStudentService {

	private IStudentDao stdDao;
	
	@Override
	public String addstudent(Student student) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.addstudent(student);
	}

	@Override
	public Student searchStudent(Integer sid) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.searchStudent(sid);
	}

	@Override
	public String updateStudent(Student student) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.updateStudent(student);
	}

	@Override
	public String deleteStudent(Integer sid) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.deleteStudent(sid);
	}

}
