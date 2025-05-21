package com.jmz.studia.domain.course;

import java.util.UUID;

public record CourseResponseDTO(UUID id, String title, UUID instructorId, Float price, Boolean isPublished) {
}
