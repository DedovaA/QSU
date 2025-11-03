package aston.final_project;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;


public class RandomlyStrategyTest {
    RandomlyStrategy randomlyStrategy;

    @Before
    public void setUp() {
        randomlyStrategy = new RandomlyStrategy();
    }

    @Test
    public void shouldGetDataToList() {
        String simulatedUserInput = "5";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        randomlyStrategy.getDataToList().forEach(System.out::println);
    }

    @After
    public void tearDown() {
        System.setIn(System.in);
    }

}
