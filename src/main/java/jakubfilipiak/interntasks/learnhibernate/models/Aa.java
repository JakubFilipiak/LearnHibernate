package jakubfilipiak.interntasks.learnhibernate.models;

import javax.persistence.*;

@Entity
public class Aa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "bb_id")
    private Bb bb;
}
