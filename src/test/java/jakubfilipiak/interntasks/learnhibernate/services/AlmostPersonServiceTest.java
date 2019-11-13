package jakubfilipiak.interntasks.learnhibernate.services;

import jakubfilipiak.interntasks.learnhibernate.models.Address;
import jakubfilipiak.interntasks.learnhibernate.models.AlmostPerson;
import jakubfilipiak.interntasks.learnhibernate.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@SpringBootTest
public class AlmostPersonServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private AlmostPersonService almostPersonService;

    @Test
    public void shouldCorrectSaveAlmostPersonWithEmbeddedAddress() {
        // given
        Address address = new Address("random county", "random city");
        AlmostPerson almostPersonToBeSaved = new AlmostPerson("random name", address);

        // when
        AlmostPerson almostPersonSaved = almostPersonService.addAlmostPerson(almostPersonToBeSaved);
        AlmostPerson almostPersonFromDb = almostPersonService.getAlmostPersonById(almostPersonSaved.getId()).get();

        // then
        assertNotNull(almostPersonFromDb);
        assertEquals(almostPersonFromDb, almostPersonToBeSaved);
    }
}