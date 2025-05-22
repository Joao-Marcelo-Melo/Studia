package com.jmz.studia.repositories;

import com.jmz.studia.domain.course.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.UUID;

public interface CoursesRepository extends JpaRepository<Course, UUID> {

    @Query("SELECT c FROM Course c WHERE c.is_published = :isPublished")
    Page<Course> findCoursesByPublishedStatus(@Param("isPublished") boolean isPublished, Pageable pageable);
}
