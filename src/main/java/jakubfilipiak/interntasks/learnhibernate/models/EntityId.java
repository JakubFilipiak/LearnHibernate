package jakubfilipiak.interntasks.learnhibernate.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class EntityId implements Serializable {

    private String key1;
    private String key2;

    public EntityId(String key1, String key2) {
        this.key1 = key1;
        this.key2 = key2;
    }
}
