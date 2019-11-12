package jakubfilipiak.interntasks.learnhibernate.utils.converters;

import jakubfilipiak.interntasks.learnhibernate.models.Color;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ColorConverter implements AttributeConverter<Color, String> {

    @Override
    public String convertToDatabaseColumn(Color color) {
        return (color != null) ? color.getFirstLetter() : null;
    }

    @Override
    public Color convertToEntityAttribute(String firstLetter) {
        return (firstLetter != null) ? Color.fromFirstLetter(firstLetter) : null;
    }
}
