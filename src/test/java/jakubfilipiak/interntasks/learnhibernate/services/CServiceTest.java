package jakubfilipiak.interntasks.learnhibernate.services;

import jakubfilipiak.interntasks.learnhibernate.models.C;
import jakubfilipiak.interntasks.learnhibernate.models.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.testng.Assert.*;

@SpringBootTest
public class CServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private CService cService;

    @Test
    public void shouldCorrectSaveC() {
        // given
        LocalDate dateToSave = LocalDate.now();
        C cToBeSaved = C.builder()
                .number(123L)
                .name("name123")
                .myDate(dateToSave)
                .myDate2(dateToSave)
                .color(Color.RED)
                .build();

        // when
        C cSaved = cService.addC(cToBeSaved);
        C cFromDb = cService.getCById(cSaved.getId()).get();

        // then
        assertEquals(cFromDb, cSaved);
    }
}