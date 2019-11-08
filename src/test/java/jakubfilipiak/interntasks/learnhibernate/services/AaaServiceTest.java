package jakubfilipiak.interntasks.learnhibernate.services;

import jakubfilipiak.interntasks.learnhibernate.models.Aa;
import jakubfilipiak.interntasks.learnhibernate.models.Aaa;
import jakubfilipiak.interntasks.learnhibernate.models.Bb;
import jakubfilipiak.interntasks.learnhibernate.models.Bbb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.testng.Assert.*;

@SpringBootTest
public class AaaServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private AaaService aaaService;

    @Test
    public void shouldCorrectSaveAaaInDbWhenBbbsNotSet() {
        // given
        Aaa aaaToBeSaved = new Aaa();

        // when
        Aaa aaaSaved = aaaService.addAaa(aaaToBeSaved);
        Aaa aaaFromDb = aaaService.getAaaById(aaaSaved.getId()).get();

        // then
        assertNotNull(aaaFromDb);
        assertEquals(aaaFromDb, aaaToBeSaved);
    }

    @Test
    public void shouldCorrectSaveAaaInDbWhenBbbsSet() {
        // given
        Aaa aaaToBeSaved = new Aaa(new HashSet<>(Arrays.asList(new Bbb(), new Bbb(), new Bbb())));

        // when
        Aaa aaaSaved = aaaService.addAaa(aaaToBeSaved);
        Aaa aaaFromDb = aaaService.getAaaById(aaaSaved.getId()).get();

        // then
        assertNotNull(aaaFromDb);
        assertEquals(aaaFromDb, aaaToBeSaved);
    }
}