package jakubfilipiak.interntasks.learnhibernate.models;

import javax.persistence.*;

@Entity
public class Bbb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aaa_id")
    private Aaa aaa;
}
