package fmi.schooltracker.entities;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Table(name = "Courses")
@Entity
public class Course {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer course_id;

    @Column(name = "course_name")
    private String course_name;

    @Column(name = "course_description")
    private String course_description;
}
