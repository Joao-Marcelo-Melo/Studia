package com.jmz.studia.controller;

import com.jmz.studia.domain.lessons.LessonRequestDTO;
import com.jmz.studia.domain.lessons.LessonResponseDTO;
import com.jmz.studia.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/courses/lessons")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @PostMapping("/{module_id}")
    public ResponseEntity<LessonResponseDTO> createLesson(@RequestBody LessonRequestDTO body, @PathVariable("module_id") UUID moduleId) {
        LessonResponseDTO lesson = this.lessonService.createLesson(body, moduleId);
        return ResponseEntity.ok(lesson);
    }
}
