package pl.zgora.uz.wiea.tna.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private long id;
    private String username;
    private String password;
}
