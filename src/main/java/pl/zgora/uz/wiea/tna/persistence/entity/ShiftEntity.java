package pl.zgora.uz.wiea.tna.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "shifts")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShiftEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "date", nullable = true)
    private Date date;

    @Column(name = "timeOfDay", nullable = true)
    @Enumerated(EnumType.STRING)
    private TimeOfDay timeOfDay;

    @OneToMany(mappedBy = "shiftEntity")
    private List<AttendanceRecordEntity> attendanceRecordEntities;
}
