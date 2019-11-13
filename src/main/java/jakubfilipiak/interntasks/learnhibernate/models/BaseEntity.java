package jakubfilipiak.interntasks.learnhibernate.models;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;
import java.util.UUID;

@Getter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @Column(updatable = false, nullable = false, unique = true)
    private final UUID id;

    public BaseEntity() {
        this.id = UUID.randomUUID();
    }

    public BaseEntity(UUID uuid) {
        this.id = uuid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object that) {
        return this == that || (that instanceof BaseEntity
                && Objects.equals(id, ((BaseEntity) that).id));
    }
}
