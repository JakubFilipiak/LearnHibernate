package jakubfilipiak.interntasks.learnhibernate.models;

import jakubfilipiak.interntasks.learnhibernate.utils.converters.ColorConverter;
import jakubfilipiak.interntasks.learnhibernate.utils.converters.LocalDateConverter;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class C {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long number;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate myDate;
    @Column(nullable = false)
    @Convert(converter = LocalDateConverter.class)
    private LocalDate myDate2;
    @Column(nullable = false)
    @Convert(converter = ColorConverter.class)
    private Color color;
}
