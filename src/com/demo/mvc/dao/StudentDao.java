package com.demo.mvc.dao;

import org.springframework.stereotype.Repository;

import com.demo.mvc.entity.Student;


public interface StudentDao<T extends Student> extends CrudDao<T> {
	
}
