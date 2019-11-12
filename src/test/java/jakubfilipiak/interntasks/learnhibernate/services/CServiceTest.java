package jakubfilipiak.interntasks.learnhibernate.services;

import jakubfilipiak.interntasks.learnhibernate.models.C;
import jakubfilipiak.interntasks.learnhibernate.models.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
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
        assertNotNull(cFromDb);
        assertEquals(cFromDb, cSaved);
    }

    @Test
    public void shouldCorrectCountCsInDbByNativeQueryOnRepo() {
        // given
        final int numberOfCsToBeSaved = 3;
        List<C> threeCsToBeSaved = prepareThreeCObjects();

        // when
        cService.addAllCs(threeCsToBeSaved);
        long numberOfCsInDb = cService.countNumberOfCsByNativeQueryOnRepo();

        // then
        assertEquals(numberOfCsInDb, numberOfCsToBeSaved);
    }

    @Test
    public void shouldCorrectCountCsInDbByNativeQueryOnEntityManager() {
        // given
        final int numberOfCsToBeSaved = 3;
        List<C> threeCsToBeSaved = prepareThreeCObjects();

        // when
        cService.addAllCs(threeCsToBeSaved);
        long numberOfCsInDb = cService.countCsInDbByNativeQueryOnEntityManager();

        // then
        assertEquals(numberOfCsInDb, numberOfCsToBeSaved);
    }

    @Test
    public void shouldCorrectCountCsInDbByFindAllAndSize() {
        // given
        final int numberOfCsToBeSaved = 3;
        List<C> threeCsToBeSaved = prepareThreeCObjects();

        // when
        cService.addAllCs(threeCsToBeSaved);
        long numberOfCsInDb = cService.countNumberOfCsByFindAllAndSize();

        // then
        assertEquals(numberOfCsInDb, numberOfCsToBeSaved);
    }

    @Test
    public void shouldCorrectCountCsWithGivenNameByNativeQuery() {
        // given
        String givenName = "ASDF";
        int numberOfCsWithGivenName = 2;
        List<C> threeCsToBeSaved = prepareThreeCObjects();

        // when
        cService.addAllCs(threeCsToBeSaved);
        int numberOfCsWithGivenNameInDB = cService.countNumberOfCsWithGivenNameByNativeQueryOnRepo(givenName);

        // then
        assertEquals(numberOfCsWithGivenNameInDB, numberOfCsWithGivenName);
    }

    @Test
    public void shouldCorrectCountNumberOfCsWithGivenNameByFindByNameWithQueryAndSize() {
        // given
        String givenName = "ASDF";
        int numberOfCsWithGivenName = 2;
        List<C> threeCsToBeSaved = prepareThreeCObjects();

        // when
        cService.addAllCs(threeCsToBeSaved);
        int numberOfCsWithGivenNameInDB = cService.countNumberOfCsWithGivenNameByFindNameWithQueryAndSize(givenName);

        // then
        assertEquals(numberOfCsWithGivenNameInDB, numberOfCsWithGivenName);
    }

    @Test
    public void shouldCorrectCountNumberOfCsWithGivenNameByFindByNameAndSize() {
        // given
        String givenName = "ASDF";
        int numberOfCsWithGivenName = 2;
        List<C> threeCsToBeSaved = prepareThreeCObjects();

        // when
        cService.addAllCs(threeCsToBeSaved);
        int numberOfCsWithGivenNameInDB = cService.countNumberOfCsWithGivenNameByFindByNameAndSize(givenName);

        // then
        assertEquals(numberOfCsWithGivenNameInDB, numberOfCsWithGivenName);
    }

    private List<C> prepareThreeCObjects() {
        LocalDate date = LocalDate.now();
        C c1 = C.builder()
                .number(1L)
                .name("ASDF")
                .myDate(date)
                .myDate2(date)
                .color(Color.RED)
                .build();
        C c2 = C.builder()
                .number(2L)
                .name("ASDF")
                .myDate(date.plusDays(1))
                .myDate2(date.plusDays(1))
                .color(Color.GREEN)
                .build();
        C c3 = C.builder()
                .number(3L)
                .name("ASDF2")
                .myDate(date.plusDays(2))
                .myDate2(date.plusDays(2))
                .color(Color.BLUE)
                .build();
        return Arrays.asList(c1, c2, c3);
    }
}