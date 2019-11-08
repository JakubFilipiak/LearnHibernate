package jakubfilipiak.interntasks.learnhibernate.models;

import javax.persistence.*;

@Entity
public class Bb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "bb")
    private Aa aa;
}
