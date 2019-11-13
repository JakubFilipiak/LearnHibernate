package jakubfilipiak.interntasks.learnhibernate.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class AlmostPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Embedded
    private Address address;

    public AlmostPerson(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
