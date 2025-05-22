package com.jmz.studia.service;

import com.jmz.studia.domain.course.Course;
import com.jmz.studia.domain.modules.ModuleRequestDTO;
import com.jmz.studia.domain.modules.ModuleResponseDTO;
import com.jmz.studia.domain.modules.Module;
import com.jmz.studia.errors.CourseNotFoundException;
import com.jmz.studia.repositories.CoursesRepository;
import com.jmz.studia.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ModuleService {

    private final ModuleRepository moduleRepository;
    private final CoursesRepository coursesRepository;

    @Autowired
    public ModuleService(ModuleRepository moduleRepository, CoursesRepository coursesRepository) {
        this.moduleRepository = moduleRepository;
        this.coursesRepository = coursesRepository;
    }

    public ModuleResponseDTO createModule(ModuleRequestDTO data, UUID courseID) {
        Course course = this.coursesRepository.findById(courseID).orElseThrow(CourseNotFoundException::new);

        Module module = Module.builder()
        .courseId(course)
        .title(data.title())
        .position(data.position())
        .build();

        this.moduleRepository.save(module);
        return new ModuleResponseDTO(
            module.getId(),
            module.getTitle(),
            module.getPosition(),
            module.getCourseId().
            getId()
        );
    }
}
