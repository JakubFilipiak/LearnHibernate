package jakubfilipiak.interntasks.learnhibernate.services;

import jakubfilipiak.interntasks.learnhibernate.models.Address;
import jakubfilipiak.interntasks.learnhibernate.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@SpringBootTest
public class PersonServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private PersonService personService;

    @Test
    public void shouldCorrectSavePersonWithEmbeddedAddress() {
        // given
        Address address = new Address("random county", "random city");
        Person personToBeSaved = new Person("random name", address);

        // when
        Person personSaved = personService.addPerson(personToBeSaved);
        Person personFromDb = personService.getPersonById(personSaved.getId()).get();

        // then
        assertNotNull(personFromDb);
        assertEquals(personFromDb, personToBeSaved);
    }
}