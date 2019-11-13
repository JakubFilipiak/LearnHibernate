package jakubfilipiak.interntasks.learnhibernate.services;

import jakubfilipiak.interntasks.learnhibernate.models.EmbeddedId;
import jakubfilipiak.interntasks.learnhibernate.models.EntityWithEmbeddedId;
import jakubfilipiak.interntasks.learnhibernate.repositories.EntityWithEmbeddedIdRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntityWithEmbeddedIdService {

    private EntityWithEmbeddedIdRepository entityWithEmbeddedIdRepository;

    public EntityWithEmbeddedIdService(EntityWithEmbeddedIdRepository entityWithEmbeddedIdRepository) {
        this.entityWithEmbeddedIdRepository = entityWithEmbeddedIdRepository;
    }

    public EntityWithEmbeddedId addEntityWithEmbeddedId(EntityWithEmbeddedId entityWithEmbeddedId) {
        return entityWithEmbeddedIdRepository.save(entityWithEmbeddedId);
    }

    public Optional<EntityWithEmbeddedId> getEntityWithEmbeddedIdByEmbeddedId(EmbeddedId embeddedId) {
        return entityWithEmbeddedIdRepository.findById(embeddedId);
    }
}
