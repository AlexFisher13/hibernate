package org.example.model;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@ToString(exclude = {"id", "address", "company"})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "address_id")
    Address address;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "company_id")
    Company company;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    List<Course> courses;

    public Student(String name) {
        this.name = name;
    }
}
