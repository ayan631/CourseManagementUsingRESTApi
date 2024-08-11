package com.springboot.main.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.main.entities.Course;
import com.springboot.main.services.CourseService;

@RestController
public class MyController {
	
	 private final CourseService courseService;

	    public MyController(CourseService courseService) {
	        this.courseService = courseService;
	    }
	
	    @GetMapping("/courses")
	    public ResponseEntity<List<Course>> getCourses() {
	        List<Course> courses = courseService.getAllCourse();
	        if (courses.isEmpty()) {
	        	// No content when list is empty
	        	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	        
	        return new ResponseEntity<>(courses, HttpStatus.OK);
	    }

	
	@GetMapping("/courses/{id}")
	public ResponseEntity<Course> getCourse(@PathVariable long id) {
		
		Course course = courseService.getCourseById(id);
		
		if(course!=null) {
			return new ResponseEntity<Course>(courseService.getCourseById(id), HttpStatus.OK);
		}
		
		else {
			return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/courses")
	public ResponseEntity<String> createCourse(@RequestBody Course newCourse){
		courseService.createNewCourse(newCourse);
		return new ResponseEntity<String>("Course Successfully created!", HttpStatus.CREATED);
	}
	
	@PutMapping("/courses")
	public ResponseEntity<Course> updateCourse(@RequestBody Course updatedCourse) {
		
		Course c = courseService.updateCourseById(updatedCourse);
		
		if(c!=null)
			return new ResponseEntity<Course>(c, HttpStatus.CREATED);
		else
			return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/courses/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable long id){
		
		long deletedId = courseService.deleteCourseById(id);
		if(deletedId==id)
			return new ResponseEntity<String>("Course with id= "+id+" is successfully deleted...!", HttpStatus.OK);
		else
			return new ResponseEntity<String>("Course with id= "+id+" does not exist...!", HttpStatus.NOT_FOUND);
	}
}
