package com.rahul.daofactory;

import com.rahul.dao.IStudentDao;
import com.rahul.dao.StudentDaoImpl;

public class StudentDaoFactory {

	private StudentDaoFactory() {

	}

	private static IStudentDao dao = null;

	public static IStudentDao getStudentDao() {

		if (dao == null)
			dao = new StudentDaoImpl();

		return dao;

	}

}
