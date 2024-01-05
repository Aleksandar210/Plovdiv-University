package fmi.schooltracker.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Table(name = "Exam_Types")
@Entity
public class Exam_Type {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer exam_type_id;

    @Column(name = "exam_type_name")
    private String exam_type_name;

    @Column(name = "exam_type_description")
    private String exam_type_description;
}
