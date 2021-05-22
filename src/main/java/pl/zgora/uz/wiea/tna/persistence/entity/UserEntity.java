package pl.zgora.uz.wiea.tna.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "username", unique = true, nullable = true)
    private String username;

    @Column(name = "password", nullable = true)
    private String password;

    @Column(name = "role", nullable = true)
    @Enumerated(EnumType.STRING)
    private Role role;
}
