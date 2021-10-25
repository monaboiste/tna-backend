package pl.zgora.uz.wiea.tna.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @SequenceGenerator(
            name="users_id_seq",
            sequenceName="users_id_seq",
            allocationSize=1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "users_id_seq")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", columnDefinition = "user_role", nullable = false)
    @Type(type = "pl.zgora.uz.wiea.tna.persistence.db.postresql.PostgreSQLEnumType")
    @Enumerated(EnumType.STRING)
    private Role role;
}
