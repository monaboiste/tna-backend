package pl.zgora.uz.wiea.tna.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
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

    @Column(name = "started_at", nullable = true)
    private OffsetDateTime startedAt;

    @Column(name = "ended_at", nullable = true)
    private OffsetDateTime endedAt;

    @OneToMany(mappedBy = "shiftEntity")
    private List<AttendanceRecordEntity> attendanceRecordEntities;
}
