package jakubfilipiak.interntasks.learnhibernate.models;

import jakubfilipiak.interntasks.learnhibernate.utils.converters.ColorConverter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Convert;
import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
public class Car extends Vehicle {

    private String name;
    @Convert(converter = ColorConverter.class)
    private Color myColor;

    public Car(String name, Color myColor) {
        super();
        this.name = name;
        this.myColor = myColor;
    }
}
