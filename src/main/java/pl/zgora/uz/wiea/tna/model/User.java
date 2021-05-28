package pl.zgora.uz.wiea.tna.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import pl.zgora.uz.wiea.tna.persistence.entity.Role;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotNull(message = "attribute.not_null")
    @JsonProperty
    private String username;

    @NotNull(message = "attribute.not_null")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Role role;
}
