package com.jmz.studia.service;


import com.jmz.studia.domain.User.User;
import com.jmz.studia.domain.course.Course;
import com.jmz.studia.domain.course.CourseRequestDTO;
import com.jmz.studia.domain.course.CourseResponseDTO;
import com.jmz.studia.infra.security.TokenService;
import com.jmz.studia.repositories.CoursesRepository;
import com.jmz.studia.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CourseService {

    private final CoursesRepository coursesRepository;
    private final UserRepository userRepository;
    private final TokenService tokenService;

    @Autowired
    public CourseService(CoursesRepository coursesRepository, UserRepository userRepository, TokenService tokenService) {
        this.coursesRepository = coursesRepository;
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    public Course createCourse(CourseRequestDTO data, String token) {
        token = this.tokenService.formatToken(token);
        String email = this.tokenService.findUserByToken(token);
        User user = (User) this.userRepository.findByEmail(email);

        Course course = Course.builder()
        .title(data.title())
        .description(data.description())
        .price(data.price())
        .is_published(data.is_published())
        .instructor_id(user)
        .build();

        this.coursesRepository.save(course);
        return course;
    }

    public List<CourseResponseDTO> getCourses(boolean isPublished, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Course> course = this.coursesRepository.findCoursesByPublishedStatus(isPublished, pageRequest);

        return course.map(e -> new CourseResponseDTO(
            e.getId(),
            e.getTitle(),
            e.getDescription(),
            e.getInstructor_id().getId(),
            e.getPrice(),
            e.getIs_published()
        )).stream().toList();
    }
}
