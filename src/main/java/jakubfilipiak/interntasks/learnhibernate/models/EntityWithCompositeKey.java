package jakubfilipiak.interntasks.learnhibernate.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@IdClass(EntityId.class)
public class EntityWithCompositeKey {

    @Id
    private String key1;
    @Id
    private String key2;

    private Long number;

    public EntityWithCompositeKey(EntityId compositeKey, Long number) {
        this.key1 = compositeKey.getKey1();
        this.key2 = compositeKey.getKey2();
        this.number = number;
    }

    public EntityId getCompositeKey() {
        return new EntityId(this.key1, this.key2);
    }
}
