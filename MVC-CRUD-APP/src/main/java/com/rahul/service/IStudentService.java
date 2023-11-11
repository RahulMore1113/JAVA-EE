package com.rahul.service;

import com.rahul.dto.Student;

public interface IStudentService 
{
	public String addstudent(Student student);
	
	public Student searchStudent(Integer sid);
	
	public String updateStudent(Student student);
	
	public String deleteStudent(Integer sid);
}
