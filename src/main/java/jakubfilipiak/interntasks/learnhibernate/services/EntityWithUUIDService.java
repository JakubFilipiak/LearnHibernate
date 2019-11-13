package jakubfilipiak.interntasks.learnhibernate.services;

import jakubfilipiak.interntasks.learnhibernate.models.EntityWithUUID;
import jakubfilipiak.interntasks.learnhibernate.repositories.EntityWithUUIDRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EntityWithUUIDService {

    private EntityWithUUIDRepository entityWithUUIDRepository;

    public EntityWithUUIDService(EntityWithUUIDRepository entityWithUUIDRepository) {
        this.entityWithUUIDRepository = entityWithUUIDRepository;
    }

    public EntityWithUUID addEntityWithUUID(EntityWithUUID entityWithUUID) {
        return entityWithUUIDRepository.save(entityWithUUID);
    }

    public Optional<EntityWithUUID> getEntityWithUUIDByUUID(UUID uuid) {
        return entityWithUUIDRepository.findById(uuid);
    }
}
