package com.jmz.studia.domain.course;

import java.util.UUID;

public record CourseRequestDTO(String title, String description, Float price, boolean is_published) {
}
