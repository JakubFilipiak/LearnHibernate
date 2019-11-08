package jakubfilipiak.interntasks.learnhibernate.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@EqualsAndHashCode
@ToString
@Entity
public class Aaa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO: Maybe better solution than eager loading?
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "aaa")
    private Set<Bbb> bbbs = new HashSet<>();

    public Aaa() {}

    public Aaa(Set<Bbb> bbbs) {
        this.bbbs = bbbs;
    }
}
