package com.springboot.main.services;

import java.util.List;
import com.springboot.main.entities.Course;

public interface MyServices {
	
	public List<Course> getAllCourse();
	public Course getCourseById(long cid);
	public void createNewCourse(Course newCourse);
	public Course updateCourseById(Course couse);
	public long deleteCourseById(long id);
	
}
