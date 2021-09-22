package pl.zgora.uz.wiea.tna.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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

    @OneToMany(mappedBy = "shiftEntity", cascade = CascadeType.PERSIST)
    private List<AttendanceRecordEntity> attendanceRecordEntities;
}
