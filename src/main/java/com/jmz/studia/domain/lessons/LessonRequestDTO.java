package com.jmz.studia.domain.lessons;

public record LessonRequestDTO(String title, String video_url, int duration_minutes, int position) {
}
