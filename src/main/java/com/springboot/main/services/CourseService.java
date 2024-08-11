package com.springboot.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.main.dao.CourseDao;
import com.springboot.main.entities.Course;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseService implements MyServices {
	@Autowired
	private CourseDao courseDao;

	 @Override
	    @Transactional(readOnly = true)
	    public List<Course> getAllCourse() {
	        try {
	            return (List<Course>) courseDao.findAll();
	        }
	        catch (Exception ex) {
	        	//Return an empty list instead of null
	        	return List.of(); 
	        }
	    }

	@Override
	@Transactional(readOnly = true)
	public Course getCourseById(long cid) {
		Optional<Course> course = courseDao.findById(cid);
		// Use Optional to handle absence gracefully
		return course.orElse(null); 
	}

	@Override
	public void createNewCourse(Course newCourse) {
		Course c = courseDao.save(newCourse);
	}

	@Override
	public Course updateCourseById(Course course) {
		if (courseDao.existsById(course.getCid())) {
			return courseDao.save(course);
		} else {
			return null;
		}
	}

	@Override
	public long deleteCourseById(long id) {
		if (courseDao.existsById(id)) {
			courseDao.deleteById(id);
			return id;
		} else {
			return 0;
		}
	}

}
