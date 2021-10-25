package pl.zgora.uz.wiea.tna.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shifts")
public class ShiftEntity {

    @Id
    @SequenceGenerator(
            name="shifts_id_seq",
            sequenceName="shifts_id_seq",
            allocationSize=1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "shifts_id_seq")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "timeOfDay", columnDefinition = "time_of_day")
//    @Type(type = "pl.zgora.uz.wiea.tna.persistence.db.postresql.PostgreSQLEnumType")
    @Enumerated(EnumType.STRING)
    private TimeOfDay timeOfDay;

    @OneToMany(mappedBy = "shiftEntity", cascade = CascadeType.PERSIST)
    private List<AttendanceRecordEntity> attendanceRecordEntities;
}
