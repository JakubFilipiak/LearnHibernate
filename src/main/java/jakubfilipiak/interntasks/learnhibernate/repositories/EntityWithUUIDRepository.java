package jakubfilipiak.interntasks.learnhibernate.repositories;

import jakubfilipiak.interntasks.learnhibernate.models.EntityWithUUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EntityWithUUIDRepository extends JpaRepository<EntityWithUUID, UUID> {

}
