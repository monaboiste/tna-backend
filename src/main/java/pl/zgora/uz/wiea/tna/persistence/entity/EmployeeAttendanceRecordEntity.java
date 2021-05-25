package pl.zgora.uz.wiea.tna.persistence.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "employee_attendance_records")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeAttendanceRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "employee_id", referencedColumnName = "user_id")
    private EmployeeEntity employeeEntity;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "attendance_record_id", referencedColumnName = "id")
    private AttendanceRecordEntity attendanceRecordEntity;
}
