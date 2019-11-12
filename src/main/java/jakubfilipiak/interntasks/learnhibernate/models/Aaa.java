package jakubfilipiak.interntasks.learnhibernate.models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Aaa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aaa")
    private Set<Bbb> bbbs = new HashSet<>();

    public Aaa() {}

    public Aaa(Set<Bbb> bbbs) {
        this.bbbs = bbbs;
    }

}
