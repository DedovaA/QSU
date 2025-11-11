package aston.final_project;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.List;


public class FromFileStrategyTest {
    FromFileStrategy fromFileStrategy;

    @Before
    public void setUp() {
        fromFileStrategy = new FromFileStrategy();
    }

    @After
    public void tearDown() {
        System.setIn(System.in);
    }

    @Test
    public void shouldGetBusList() throws CustomException {
        String simulatedUserInput = "./src/main/resources/list";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        List<Bus> list = fromFileStrategy.getBusList();
        list.forEach(System.out::println);
    }


}
