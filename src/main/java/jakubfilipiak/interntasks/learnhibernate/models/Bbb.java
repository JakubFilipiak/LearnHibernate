package jakubfilipiak.interntasks.learnhibernate.models;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@EqualsAndHashCode
@ToString
@Entity
public class Bbb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aaa_id")
    private Aaa aaa;
}
