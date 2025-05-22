package com.jmz.studia.controller;


import com.jmz.studia.domain.module.ModuleRequestDTO;
import com.jmz.studia.domain.module.ModuleResponseDTO;
import com.jmz.studia.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/courses/modules")
public class ModuleController {

    @Autowired
    private final ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }


    @PostMapping("/{course_id}")
    public ResponseEntity<ModuleResponseDTO> createModule(@RequestBody ModuleRequestDTO body, @PathVariable("course_id") UUID courseId) {
        ModuleResponseDTO module = this.moduleService.createModule(body, courseId);

        return ResponseEntity.ok(module);
    }
}
