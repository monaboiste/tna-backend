package pl.zgora.uz.wiea.tna.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank(message = "attribute.not_blank")
    @JsonProperty
    private String firstName;

    @NotBlank(message = "attribute.not_blank")
    @JsonProperty
    private String lastName;

    @NotBlank(message = "attribute.not_blank")
    @JsonProperty
    private String department;

    @NotBlank(message = "attribute.not_blank")
    @JsonProperty
    private String street;

    @NotNull(message = "attribute.not_null")
    @Pattern(message = "attribute.invalid_pattern", regexp = "^([\\d]{2}-[\\d]{3})$")
    @JsonProperty
    private String postCode;

    @NotBlank(message = "attribute.not_blank")
    private String city;

    @NotNull(message = "attribute.not_null")
    @Pattern(message = "attribute.invalid_pattern", regexp = "^[A-Za-z0-9]{3,}$")
    @JsonProperty
    private String contractId;
}
