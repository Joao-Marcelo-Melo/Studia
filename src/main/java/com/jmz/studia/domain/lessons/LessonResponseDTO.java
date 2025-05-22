package com.jmz.studia.domain.lessons;

import java.util.UUID;

public record LessonResponseDTO(UUID id, String title, int position, int duration) {
}
