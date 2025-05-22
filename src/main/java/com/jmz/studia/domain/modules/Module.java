package com.jmz.studia.domain.modules;


import com.jmz.studia.domain.course.Course;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "modules")
@Builder
@Entity
public class Module {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course courseId;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = false)
    private int position;
}
