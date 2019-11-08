package jakubfilipiak.interntasks.learnhibernate.models;

import javax.persistence.*;

@Entity
public class A {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "b_id")
    private B b;
}
