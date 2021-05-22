package pl.zgora.uz.wiea.tna.model;

import lombok.*;
import pl.zgora.uz.wiea.tna.persistence.entity.UserEntity;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private long id;
    private User user;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String street;
    private String postCode;
    private String city;
}
