package jakubfilipiak.interntasks.learnhibernate.services;

import jakubfilipiak.interntasks.learnhibernate.models.Aa;
import jakubfilipiak.interntasks.learnhibernate.models.Bb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@SpringBootTest
public class AaServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private AaService aaService;

    @Test
    public void shouldCorrectSaveAaInDbWhenBbNotSet() {
        // given
        Aa aaToBeSaved = new Aa();

        // when
        Aa aaSaved = aaService.addAa(aaToBeSaved);
        Aa aaFromDb = aaService.getAaById(aaSaved.getId()).get();

        // then
        assertNotNull(aaFromDb);
        assertEquals(aaFromDb, aaToBeSaved);
    }

    @Test
    public void shouldCorrectSaveAaInDbWhenBbSet() {
        // given
        Aa aaToBeSaved = new Aa(new Bb());

        // when
        Aa aaSaved = aaService.addAa(aaToBeSaved);
        Aa aaFromDb = aaService.getAaById(aaSaved.getId()).get();

        // then
        assertNotNull(aaFromDb);
        assertEquals(aaFromDb, aaToBeSaved);
    }
}