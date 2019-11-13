package jakubfilipiak.interntasks.learnhibernate.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Embeddable
public class EmbeddedId implements Serializable {

    private String key1;
    private String key2;

    public EmbeddedId(String key1, String key2) {
        this.key1 = key1;
        this.key2 = key2;
    }
}
