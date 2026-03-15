package com.gal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.gal.dao.DepartmentDao;
import com.gal.model.Department;

@SpringBootApplication
public class BootcompanyApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(BootcompanyApplication.class, args);
		DepartmentDao dao=context.getBean(DepartmentDao.class);
		Department department= dao.find(10);
		System.out.println(department);
	}
}
