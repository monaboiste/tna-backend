package pl.zgora.uz.wiea.tna.persistence.entity;

import lombok.*;

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

    @Id
    @Column(name = "user_id", unique = true, nullable = false)
    private Long userId;

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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @MapsId(value = "user_id")
    @PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "employeeEntity")
    private List<EmployeeAttendanceRecordEntity> employeeAttendanceRecordEntities;
}
