package in.co.decimal.learnspringboot.courses.controller;

import in.co.decimal.learnspringboot.courses.bean.Course;
import in.co.decimal.learnspringboot.courses.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

	// We need make use of CourseRepository inside the CourseController
	// And we need to Autowired in it...
	@Autowired
	private CourseRepository courseRepository;

	// GET - Retrive information (/cousres)

	// http://localhost:8080/courses
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		/**
		 * Make use of the CourseRepository get the data from the database:
		 */
		return courseRepository.findAll();
	}

	// GET - Retrive information (/cousres/1)

	// http://localhost:8080/courses/(like id=1)
	@GetMapping("/courses/{id}")
	public Course getCourseDetails(@PathVariable long id){
		Optional<Course> byId = courseRepository.findById(id);
		if(byId.isEmpty()){
			throw new RuntimeException("Course not found with id "+id);
		}
		return byId.get();
	}

	// POST - Create a new resource (/courses)
	// http://localhost:8080/courses
	@PostMapping("/courses")
	public void createCourse(@RequestBody Course course){
		courseRepository.save(course);
	}

	// PUT - Update/Replace a resource(/courses/1)
	// http://localhost:8080/courses/1(Like id = 1)
	@PutMapping("/courses/{id}")
	public void updateCourse(@PathVariable long id, @RequestBody Course course){
		courseRepository.save(course);
	}


	// PUT - Delete a resource(/courses/1)
	// http://localhost:8080/courses/1(Like id = 1)
	@DeleteMapping("/courses/{id}")
	public void deleteCourse(@PathVariable long id){
		Optional<Course> byId = courseRepository.findById(id);
		if(byId.isEmpty()){
			throw new EmptyResultDataAccessException((int)id);
		}
		courseRepository.deleteById(id);

	}

}
