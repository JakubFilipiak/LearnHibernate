package jakubfilipiak.interntasks.learnhibernate.utils.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Converter
public class LocalDateConverter implements AttributeConverter<LocalDate, Long> {

    @Override
    public Long convertToDatabaseColumn(LocalDate localDate) {
        return (localDate != null) ? localDate.atStartOfDay(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli() : null;
    }

    @Override
    public LocalDate convertToEntityAttribute(Long timeInMillis) {
        return (timeInMillis != null)? Instant.ofEpochMilli(timeInMillis)
                .atZone(ZoneId.systemDefault())
                .toLocalDate() : null;
    }
}
