package pl.zgora.uz.wiea.tna.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PreRemove;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
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
        for (AttendanceRecordEntity recordEntity : employeeAttendanceRecordEntities) {
            recordEntity.setEmployeeEntity(null);
        }
    }
}
