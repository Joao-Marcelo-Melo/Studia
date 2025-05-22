package com.jmz.studia.controller;

import com.jmz.studia.domain.course.Course;
import com.jmz.studia.domain.course.CourseRequestDTO;
import com.jmz.studia.domain.course.CourseResponseDTO;
import com.jmz.studia.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<CourseResponseDTO> addCourse(@RequestBody CourseRequestDTO body, @RequestHeader("Authorization") String token) {
        Course course = this.courseService.createCourse(body, token);
        return ResponseEntity.ok(new CourseResponseDTO(
            course.getId(),
            course.getTitle(),
            course.getDescription(),
            course.getInstructor_id().getId(),
            course.getPrice(),
            course.getIs_published()
        ));
    }

    @GetMapping
    public ResponseEntity<List<CourseResponseDTO>> getAllCourses(@RequestParam(defaultValue = "true") boolean is_published,
     @RequestParam(defaultValue = "0") int page,
     @RequestParam(defaultValue = "10") int size) {
        List<CourseResponseDTO> courses = this.courseService.getCourses(is_published, page, size);
        return ResponseEntity.ok(courses);
    }
}
