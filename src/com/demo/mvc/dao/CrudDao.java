package com.demo.mvc.dao;

import java.util.List;

import com.demo.mvc.entity.Student;

public interface CrudDao<T> {
	
	T add(Integer id);
	void bulkAdd(String data);
	List<T> retrieveAll();
	T retrieveById(Integer id);
	T retrieveByFirstName(String firstName);
	T update(Integer id);
	void bulkUpdate(String data);
	void remove();

}
