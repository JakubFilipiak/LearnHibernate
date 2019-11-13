package jakubfilipiak.interntasks.learnhibernate.services;

import jakubfilipiak.interntasks.learnhibernate.models.CompositeKey;
import jakubfilipiak.interntasks.learnhibernate.models.EntityWithCompositeKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.*;

@SpringBootTest
public class EntityWithCompositeKeyServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private EntityWithCompositeKeyService entityWithCompositeKeyService;

    @Test
    public void shouldCorrectSaveEntityWithCompositeKey() {
        // given
        CompositeKey compositeKey = new CompositeKey("value1", "value2");
        EntityWithCompositeKey entityWithCompositeKeyToBeSaved =
                new EntityWithCompositeKey(compositeKey, new Random().nextLong());

        // when
        EntityWithCompositeKey entityWithCompositeKeySaved =
                entityWithCompositeKeyService.addEntityWithCompositeKey(entityWithCompositeKeyToBeSaved);
        EntityWithCompositeKey entityWithCompositeKeyFromDb =
                entityWithCompositeKeyService.getEntityWithCompositeKeyByCompositeKey(
                        entityWithCompositeKeySaved.getCompositeKey()).get();

        // then
        assertNotNull(entityWithCompositeKeyFromDb);
        assertEquals(entityWithCompositeKeyFromDb, entityWithCompositeKeyToBeSaved);
    }
}