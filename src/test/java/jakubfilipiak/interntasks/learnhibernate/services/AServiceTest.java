package jakubfilipiak.interntasks.learnhibernate.services;

import jakubfilipiak.interntasks.learnhibernate.models.A;
import jakubfilipiak.interntasks.learnhibernate.models.B;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@SpringBootTest
public class AServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private AService aService;

    @Test
    public void shouldCorrectSaveAInDbWhenBNotSet() {
        // given
        A aToBeSaved = new A();

        // when
        A aSaved = aService.addA(aToBeSaved);
        A aFromDb = aService.getAById(aSaved.getId()).get();

        // then
        assertNotNull(aFromDb);
        assertEquals(aFromDb, aToBeSaved);
    }

    @Test
    public void shouldCorrectSaveAInDbWhenBSet() {
        // given
        A aToBeSaved = new A(new B());

        // when
        A aSaved = aService.addA(aToBeSaved);
        A aFromDb = aService.getAById(aSaved.getId()).get();

        // then
        assertNotNull(aFromDb);
        assertEquals(aFromDb, aToBeSaved);
    }
}