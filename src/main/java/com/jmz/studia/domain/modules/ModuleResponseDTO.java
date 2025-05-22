package com.jmz.studia.domain.modules;

import java.util.UUID;

public record ModuleResponseDTO(UUID id, String title, int position, UUID courseId) {
}
