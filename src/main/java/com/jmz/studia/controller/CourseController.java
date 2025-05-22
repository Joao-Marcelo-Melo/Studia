package com.jmz.studia.controller;

import com.jmz.studia.domain.course.Course;
import com.jmz.studia.domain.course.CourseRequestDTO;
import com.jmz.studia.domain.course.CourseResponseDTO;
import com.jmz.studia.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
            course.getInstructor_id().getId(),
            course.getPrice(),
            course.getIs_published()
        ));
    }

    @GetMapping
    public ResponseEntity<List<CourseResponseDTO>> getAllCourses() {
        List<Course> courses = this.courseService.getALlCourses();

        List<CourseResponseDTO> response = courses.stream()
            .map(course -> new CourseResponseDTO(
                    course.getId(),
                    course.getTitle(),
                    course.getInstructor_id().getId(),
                    course.getPrice(),
                    course.getIs_published()
            ))
            .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}
