package jakubfilipiak.interntasks.learnhibernate.services;

import jakubfilipiak.interntasks.learnhibernate.models.EntityWithUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.*;

@SpringBootTest
public class EntityWithUUIDServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private EntityWithUUIDService entityWithUUIDService;

    @Test
    public void shouldCorrectSaveEntityWithUUID() {
        // given
        EntityWithUUID entityWithUUIDToBeSaved = new EntityWithUUID(new Random().nextLong());

        // when
        EntityWithUUID entityWithUUIDSaved = entityWithUUIDService.addEntityWithUUID(entityWithUUIDToBeSaved);
        EntityWithUUID entityWithUUIDFromDb =
                entityWithUUIDService.getEntityWithUUIDByUUID(entityWithUUIDSaved.getId()).get();

        // then
        assertNotNull(entityWithUUIDFromDb);
        assertEquals(entityWithUUIDFromDb, entityWithUUIDToBeSaved);
    }
}