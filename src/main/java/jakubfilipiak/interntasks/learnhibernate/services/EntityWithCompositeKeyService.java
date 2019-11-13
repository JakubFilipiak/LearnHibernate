package jakubfilipiak.interntasks.learnhibernate.services;

import jakubfilipiak.interntasks.learnhibernate.models.CompositeKey;
import jakubfilipiak.interntasks.learnhibernate.models.EntityWithCompositeKey;
import jakubfilipiak.interntasks.learnhibernate.repositories.EntityWithCompositeKeyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntityWithCompositeKeyService {

    private EntityWithCompositeKeyRepository entityWithCompositeKeyRepository;

    public EntityWithCompositeKeyService(EntityWithCompositeKeyRepository entityWithCompositeKeyRepository) {
        this.entityWithCompositeKeyRepository = entityWithCompositeKeyRepository;
    }

    public EntityWithCompositeKey addEntityWithCompositeKey(EntityWithCompositeKey entityWithCompositeKey) {
        return entityWithCompositeKeyRepository.save(entityWithCompositeKey);
    }

    public Optional<EntityWithCompositeKey> getEntityWithCompositeKeyByCompositeKey(CompositeKey compositeKey) {
        return entityWithCompositeKeyRepository.findById(compositeKey);
    }
}
