package pl.zgora.uz.wiea.tna.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import pl.zgora.uz.wiea.tna.persistence.entity.TimeOfDay;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shift {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotNull(message = "attribute.time_of_day")
    @JsonProperty
    private TimeOfDay timeOfDay;

    @NotNull(message = "attribute.date")
    @JsonProperty
    private Date date;
}
