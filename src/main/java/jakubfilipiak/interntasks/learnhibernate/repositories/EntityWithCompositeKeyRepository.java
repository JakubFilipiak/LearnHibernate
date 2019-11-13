package jakubfilipiak.interntasks.learnhibernate.repositories;

import jakubfilipiak.interntasks.learnhibernate.models.CompositeKey;
import jakubfilipiak.interntasks.learnhibernate.models.EntityWithCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityWithCompositeKeyRepository extends JpaRepository<EntityWithCompositeKey, CompositeKey> {

}
