package pl.zgora.uz.wiea.tna.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import pl.zgora.uz.wiea.tna.persistence.entity.TimeOfDay;

import java.sql.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shift {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @JsonProperty
    private TimeOfDay timeOfDay;

    @JsonProperty
    private Date date;
}
