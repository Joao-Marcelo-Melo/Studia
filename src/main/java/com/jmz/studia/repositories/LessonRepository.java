package com.jmz.studia.repositories;

import com.jmz.studia.domain.lessons.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LessonRepository extends JpaRepository<Lesson, UUID> {
}
