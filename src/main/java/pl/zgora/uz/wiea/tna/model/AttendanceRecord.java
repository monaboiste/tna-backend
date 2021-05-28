package pl.zgora.uz.wiea.tna.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import pl.zgora.uz.wiea.tna.util.DateTimeDeserializer;
import pl.zgora.uz.wiea.tna.util.DateTimeSerializer;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceRecord {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotNull(message = "attribute.required")
    @JsonProperty
    private Long employeeId;

    @JsonProperty
    private Long shiftId;

    @NotNull(message = "attribute.offset_date_time_format")
    @JsonProperty
    @JsonSerialize(using = DateTimeSerializer.class)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private OffsetDateTime enteredAt;

    @NotNull(message = "attribute.offset_date_time_format")
    @JsonProperty
    @JsonSerialize(using = DateTimeSerializer.class)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private OffsetDateTime leftAt;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long elapsedTimePerShiftInMinutes;
}
