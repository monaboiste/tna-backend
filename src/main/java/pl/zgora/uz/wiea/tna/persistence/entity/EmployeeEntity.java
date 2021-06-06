package pl.zgora.uz.wiea.tna.persistence.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {

    /**
     * Shares PK with {@link UserEntity}
     * See: {@link UserEntity#getId()}
     */
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "contract_id", unique = true, nullable = false)
    private String contractId;

    @Column(name = "street", nullable = true)
    private String street;

    @Column(name = "post_code", nullable = true)
    private String postCode;

    @Column(name = "city", nullable = true)
    private String city;

    @MapsId
    @OneToOne(
            cascade = CascadeType.REMOVE,
            fetch = FetchType.EAGER,
            optional = false,
            orphanRemoval = true)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserEntity userEntity;

    @OneToMany(mappedBy = "employeeEntity")
    private List<AttendanceRecordEntity> employeeAttendanceRecordEntities;

    @PreRemove
    private void preRemove() {
        for (AttendanceRecordEntity record : employeeAttendanceRecordEntities) {
            record.setEmployeeEntity(null);
        }
    }
}
