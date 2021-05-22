package pl.zgora.uz.wiea.tna.persistence.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @Column(name = "first_name", updatable = false, nullable = false)
    private String firstName;

    @Column(name = "last_name", updatable = false, nullable = false)
    private String lastName;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "post_code", nullable = false)
    private String postCode;

    @Column(name = "city", nullable = false)
    private String city;
}

