package fmi.schooltracker.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

enum AttendenceStatus {
    attendent,
    non_attendent
}

@Data
@Getter
@Setter
@Table(name = "Attendences")
@Entity
public class Attendance {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attendence_id;

    @Column(name = "attendence_date")
    private Date attendence_date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;

    @Column(name = "attendence_status", columnDefinition = "ENUM('attendent', 'non_attendent')")
    @Enumerated(EnumType.STRING)
    private AttendenceStatus attendence_status;

    @Column(name = "remarks")
    private String remarks;
}
