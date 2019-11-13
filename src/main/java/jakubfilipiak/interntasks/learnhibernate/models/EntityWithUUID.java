package jakubfilipiak.interntasks.learnhibernate.models;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import java.util.UUID;

@ToString
@Getter
@Entity
public class EntityWithUUID extends BaseEntity {

    private Long number;

    public EntityWithUUID() {
        super();
    }

    public EntityWithUUID(UUID uuid) {
        super(uuid);
    }

    public EntityWithUUID(Long number) {
        super();
        this.number = number;
    }

    public EntityWithUUID(UUID uuid, Long number) {
        super(uuid);
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
