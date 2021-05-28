package pl.zgora.uz.wiea.tna.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateTimeDeserializer extends JsonDeserializer<OffsetDateTime> {

    @Override
    public OffsetDateTime deserialize(final JsonParser parser,
                              final DeserializationContext context)
                              throws IOException, JsonProcessingException {

        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                .ofPattern("yyyy/MM/dd HH:mm:ss")
                .withZone(ZoneOffset.UTC);
        return OffsetDateTime.parse(parser.getText(), dateTimeFormatter);
    }
}
