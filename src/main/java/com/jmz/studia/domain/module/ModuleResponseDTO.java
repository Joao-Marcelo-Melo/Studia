package com.jmz.studia.domain.module;

import java.util.UUID;

public record ModuleResponseDTO(UUID id, String title, int position, UUID courseId) {
}
