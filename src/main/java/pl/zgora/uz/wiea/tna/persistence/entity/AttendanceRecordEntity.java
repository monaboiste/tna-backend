package pl.zgora.uz.wiea.tna.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "attendance_records")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "entered_at", nullable = true)
    private OffsetDateTime enteredAt;

    @Column(name = "left_at", nullable = true)
    private OffsetDateTime leftAt;

    @Transient
    private Long shiftDurationInHours;

    @ManyToMany(mappedBy = "attendanceRecords")
    private List<EmployeeEntity> employeeEntities;
}
