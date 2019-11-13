package jakubfilipiak.interntasks.learnhibernate.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@ToString
@Getter
@EqualsAndHashCode
@Entity
public class EntityWithUUID {

    @Id
    @Column(updatable = false, nullable = false, unique = true)
    private final UUID id;

    private Long number;

    public EntityWithUUID() {
        this.id = UUID.randomUUID();
    }

    public EntityWithUUID(Long number) {
        this.id = UUID.randomUUID();
        this.number = number;
    }
}
