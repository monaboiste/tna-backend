package pl.zgora.uz.wiea.tna.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private long id;
    private String firstName;
    private String lastName;
    private String street;
    private String postCode;
    private String city;
    private String contractId;
}
