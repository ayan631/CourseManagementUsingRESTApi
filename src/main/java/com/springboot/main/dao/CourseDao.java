package com.springboot.main.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.main.entities.Course;

@Repository
public interface CourseDao extends CrudRepository<Course, Long>{
	
}
