package com.rahul.servicefactory;

import com.rahul.service.IStudentService;
import com.rahul.service.StudentServiceImpl;

public class StudentServiceFactory 
{
	private StudentServiceFactory()
	{
		
	}
	private static IStudentService studentService = null;
	
	public static IStudentService getStudentService()
	{
		if (studentService == null) 
		{
			studentService = new StudentServiceImpl();			
		}
		return studentService;
	}
}
