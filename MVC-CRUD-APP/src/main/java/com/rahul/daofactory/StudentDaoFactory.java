package com.rahul.daofactory;

import com.rahul.persistence.IStudentDao;
import com.rahul.persistence.StudentDaoImpl;

public class StudentDaoFactory 
{
	private StudentDaoFactory()
	{
		
	}
	
	private static IStudentDao studentDao = null;
	
	public static IStudentDao getStudentDao()
	{
		if (studentDao == null) 
		{
			studentDao = new StudentDaoImpl();
		}
		return studentDao;
	}
}
