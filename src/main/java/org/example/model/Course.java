package org.example.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PROTECTED)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    List<Student> students;

    public Course(String title) {
        this.title = title;
    }
}
