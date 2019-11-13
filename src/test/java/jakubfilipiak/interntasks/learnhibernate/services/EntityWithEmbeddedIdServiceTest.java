package jakubfilipiak.interntasks.learnhibernate.services;

import jakubfilipiak.interntasks.learnhibernate.models.EmbeddedId;
import jakubfilipiak.interntasks.learnhibernate.models.EntityWithEmbeddedId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.*;

@SpringBootTest
public class EntityWithEmbeddedIdServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private EntityWithEmbeddedIdService entityWithEmbeddedIdService;

    @Test
    public void shouldCorrectSaveEntityWithEmbeddedId() {
        // given
        EmbeddedId embeddedId = new EmbeddedId("value1", "value2");
        EntityWithEmbeddedId entityWithEmbeddedIdToBeSaved =
                new EntityWithEmbeddedId(embeddedId, new Random().nextLong());

        // when
        EntityWithEmbeddedId entityWithEmbeddedIdSaved =
                entityWithEmbeddedIdService.addEntityWithEmbeddedId(entityWithEmbeddedIdToBeSaved);
        EntityWithEmbeddedId entityWithEmbeddedIdFromDb =
                entityWithEmbeddedIdService.getEntityWithEmbeddedIdByEmbeddedId(
                        entityWithEmbeddedIdSaved.getEmbeddedId()).get();

        // then
        assertNotNull(entityWithEmbeddedIdFromDb);
        assertEquals(entityWithEmbeddedIdFromDb, entityWithEmbeddedIdToBeSaved);
    }
}