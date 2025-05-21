package com.jmz.studia.repositories;

import com.jmz.studia.domain.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CoursesRepository extends JpaRepository<Course, UUID> {
}
