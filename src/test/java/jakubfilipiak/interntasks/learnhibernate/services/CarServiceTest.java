package jakubfilipiak.interntasks.learnhibernate.services;

import jakubfilipiak.interntasks.learnhibernate.models.Car;
import jakubfilipiak.interntasks.learnhibernate.models.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@SpringBootTest
public class CarServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private CarService carService;

    @Test
    public void shouldCorrectSaveBike() {
        // given
        Car carToBeSaved = new Car("car1", Color.RED);

        // when
        Car carSaved = carService.addCar(carToBeSaved);
        Car carFromDb = carService.getCarById(carSaved.getId()).get();

        // then
        assertNotNull(carFromDb);
        assertEquals(carFromDb, carToBeSaved);
    }
}