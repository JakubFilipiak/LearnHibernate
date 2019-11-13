package jakubfilipiak.interntasks.learnhibernate.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class EntityWithEmbeddedId {

    @EmbeddedId
    private jakubfilipiak.interntasks.learnhibernate.models.EmbeddedId embeddedId;

    private Long number;

    public EntityWithEmbeddedId(jakubfilipiak.interntasks.learnhibernate.models.EmbeddedId embeddedId, Long number) {
        this.embeddedId = embeddedId;
        this.number = number;
    }
}
