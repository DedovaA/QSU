package aston.final_project;

import org.junit.After;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static aston.final_project.Utility.getListSize;
import static aston.final_project.Utility.mapStringToBus;
import static org.junit.Assert.assertThrows;

public class UtilityTest {


    @Test
    public void shouldMapStringToBus() {
        String string = ",,";
        Bus bus = mapStringToBus(string);
        System.out.println(bus);
    }

    @Test
    public void invalidFieldCountMapStringToBus() {
        Throwable throwable = assertThrows(CustomException.class, () -> Utility.mapStringToBus("MAN, X00ME, 98000,"));
        System.out.println(throwable.getMessage());
    }

    @Test
    public void invalidRunMapStringToBus() throws CustomException{
        Throwable throwable = assertThrows(CustomException.class, () -> Utility.mapStringToBus("MAN, X00ME, opp"));
        System.out.println(throwable.getMessage());
    }

    @Test
    public void shouldNotMapStringToBus() {
        Throwable throwable = assertThrows(CustomException.class, () -> Utility.mapStringToBus("MAN, X00ME, 98000,"));
        System.out.println(throwable.getMessage());
    }


    @Test
    public void shouldGetListSize() {
        String simulatedUserInput = "k\n \n-1\n0\n2";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        System.out.println(getListSize());
    }


    @After
    public void tearDown() {
        System.setIn(System.in);
    }

}