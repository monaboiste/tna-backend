package pl.zgora.uz.wiea.tna.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private long id;
    private String username;

    @JsonIgnore
    private String password;
}
