package jakubfilipiak.interntasks.learnhibernate.repositories;

import jakubfilipiak.interntasks.learnhibernate.models.EmbeddedId;
import jakubfilipiak.interntasks.learnhibernate.models.EntityWithEmbeddedId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityWithEmbeddedIdRepository extends JpaRepository<EntityWithEmbeddedId, EmbeddedId> {

}
