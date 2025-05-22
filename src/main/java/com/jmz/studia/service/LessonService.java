package com.jmz.studia.service;

import com.jmz.studia.domain.lessons.Lesson;
import com.jmz.studia.domain.lessons.LessonRequestDTO;
import com.jmz.studia.domain.lessons.LessonResponseDTO;
import com.jmz.studia.domain.module.Module;
import com.jmz.studia.errors.ModuleNotFoundException;
import com.jmz.studia.repositories.LessonRepository;
import com.jmz.studia.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private ModuleRepository moduleRepository;

    public LessonResponseDTO createLesson(LessonRequestDTO data, UUID module_id) {
        Module module = this.moduleRepository.findById(module_id).orElseThrow(ModuleNotFoundException::new);

        Lesson lesson = Lesson.builder()
        .title(data.title())
        .module(module)
        .video_url(data.video_url())
        .position(data.position())
        .duration_minutes(data.duration_minutes())
        .build();

        this.lessonRepository.save(lesson);

        return new LessonResponseDTO(
            lesson.getId(),
            lesson.getTitle(),
            lesson.getPosition(),
            lesson.getDuration_minutes()
        );
    }
}
