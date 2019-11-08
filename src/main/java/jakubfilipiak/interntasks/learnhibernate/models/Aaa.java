package jakubfilipiak.interntasks.learnhibernate.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Aaa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "aaa")
    private Set<Bbb> bbbs;
}
