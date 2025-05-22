package com.jmz.studia.domain.course;

import com.jmz.studia.domain.User.User;
import jakarta.persistence.*;
        import lombok.*;

        import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
@Builder
@Entity
public class Course {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = false, length = 150)
    private String description;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private User instructor_id;

    @Column(nullable = false)
    private Float price;

    @Column(nullable = false)
    private Boolean  is_published;
}
