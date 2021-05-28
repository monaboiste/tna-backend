package pl.zgora.uz.wiea.tna.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import pl.zgora.uz.wiea.tna.util.DateTimeDeserializer;
import pl.zgora.uz.wiea.tna.util.DateTimeSerializer;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Getter
@Setter
public class AttendanceRecordEntryTime {

    @NotNull(message = "attribute.offset_date_time_format")
    @JsonProperty
    @JsonSerialize(using = DateTimeSerializer.class)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private OffsetDateTime enteredAt;
}
