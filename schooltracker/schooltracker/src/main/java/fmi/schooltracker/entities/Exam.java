package fmi.schooltracker.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Data
@Getter
@Setter
@Table(name = "Exams")
@Entity
public class Exam {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer exam_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "exam_type_id", referencedColumnName = "exam_type_id")
    private Exam_Type examType;

    @Column(name = "exam_name")
    private String exam_name;

    @Column(name = "start_date")
    private Date start_Date;
}
