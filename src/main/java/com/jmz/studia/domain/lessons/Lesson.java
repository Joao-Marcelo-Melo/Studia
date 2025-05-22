package com.jmz.studia.domain.lessons;

import com.jmz.studia.domain.module.Module;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lessons")
@Builder
@Entity
public class Lesson {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String video_url;

    @Column(nullable = false)
    private Integer duration_minutes;

    @Column(nullable = false)
    private Integer position;
}
