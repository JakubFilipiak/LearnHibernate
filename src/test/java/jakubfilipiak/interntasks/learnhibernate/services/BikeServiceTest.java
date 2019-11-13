package jakubfilipiak.interntasks.learnhibernate.services;

import jakubfilipiak.interntasks.learnhibernate.models.Bike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.*;

@SpringBootTest
public class BikeServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private BikeService bikeService;

    @Test
    public void shouldCorrectSaveBike() {
        // given
        Bike bikeToBeSaved = new Bike(new Random().nextLong());

        // when
        Bike bikeSaved = bikeService.addBike(bikeToBeSaved);
        Bike bikeFromDb = bikeService.findBikeById(bikeSaved.getId()).get();

        // then
        assertNotNull(bikeFromDb);
        assertEquals(bikeFromDb, bikeToBeSaved);
    }

    @Test(expectedExceptions = DataIntegrityViolationException.class)
    public void shouldCorrectNotSaveTwoBikesWithTheSameNumber() {
        // given
        Long number = new Random().nextLong();
        Bike bike1ToBeSaved = new Bike(number);
        Bike bike2ToBeSaved = new Bike(number);

        // when
        Bike bike1Saved = bikeService.addBike(bike1ToBeSaved);
        Bike bike2Saved = bikeService.addBike(bike2ToBeSaved);
        Bike bike1FromDb = bikeService.findBikeById(bike1Saved.getId()).get();

        // then
        assertNull(bike2Saved);
        assertEquals(bike1FromDb, bike1ToBeSaved);
    }
}