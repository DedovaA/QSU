package aston.final_project;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static aston.final_project.ValidationUtils.*;
import static org.junit.Assert.assertThrows;

public class ValidationUtilsTest {

    @Test
    public void shouldMapStringToBus() {
        String simulatedUserInput = ",,";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
    }
    @Test
    public void shouldMapStringToBus1() {
        String simulatedUserInput = "a,,";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
    }
    @Test
    public void shouldMapStringToBus2() {
        String simulatedUserInput = ",a,";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
    }
    @Test
    public void shouldMapStringToBus3() {
        String simulatedUserInput = ",,a";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
    }


    @Test
    public void userInputConsistOfThreeFields() {
        String simulatedUserInput = ",,";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Assert.assertTrue(isUserInputConsistOfThreeFields(simulatedUserInput));
    }
    @Test
    public void userInputConsistOfThreeFields2() {
        String simulatedUserInput = "a,,";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Assert.assertTrue(isUserInputConsistOfThreeFields(simulatedUserInput));
    }
    @Test
    public void userInputConsistOfThreeFields3() {
        String simulatedUserInput = "a,a,";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Assert.assertTrue(isUserInputConsistOfThreeFields(simulatedUserInput));
    }
    @Test
    public void userInputConsistOfThreeFields4() {
        String simulatedUserInput = "a,a,a";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Assert.assertTrue(isUserInputConsistOfThreeFields(simulatedUserInput));
    }
    @Test
    public void userInputConsistOfThreeFields5() {
        String simulatedUserInput = ",a,";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Assert.assertTrue(isUserInputConsistOfThreeFields(simulatedUserInput));
    }
    @Test
    public void userInputConsistOfThreeFields6() {
        String simulatedUserInput = ",a,a";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Assert.assertTrue(isUserInputConsistOfThreeFields(simulatedUserInput));
    }
    @Test
    public void userInputConsistOfThreeFields7() {
        String simulatedUserInput = ",,a";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Assert.assertTrue(isUserInputConsistOfThreeFields(simulatedUserInput));
    }
    @Test
    public void userInputIsNotConsistOfThreeFields() {
        String simulatedUserInput = ",";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Assert.assertFalse(isUserInputConsistOfThreeFields(simulatedUserInput));
    }
    @Test
    public void userInputIsNotConsistOfThreeFields2() {
        String simulatedUserInput = "a,a";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Assert.assertFalse(isUserInputConsistOfThreeFields(simulatedUserInput));
    }
    @Test
    public void userInputIsNotConsistOfThreeFields3() {
        String simulatedUserInput = ",a";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Assert.assertFalse(isUserInputConsistOfThreeFields(simulatedUserInput));
    }
    @Test
    public void userInputIsNotConsistOfThreeFields4() {
        String simulatedUserInput = "aaa";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Assert.assertFalse(isUserInputConsistOfThreeFields(simulatedUserInput));
    }
    @Test
    public void userInputIsNotConsistOfThreeFields5() {
        String simulatedUserInput = "a,a,a,";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Assert.assertFalse(isUserInputConsistOfThreeFields(simulatedUserInput));
    }
    @Test
    public void userInputIsNotConsistOfThreeFields6() {
        String simulatedUserInput = ",,,";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Assert.assertFalse(isUserInputConsistOfThreeFields(simulatedUserInput));
    }
    @Test
    public void userInputIsNotConsistOfThreeFields7() {
        String simulatedUserInput = "a,a,a,a,";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Assert.assertFalse(isUserInputConsistOfThreeFields(simulatedUserInput));
    }

    @Test
    public void runIsValid() {
        String simulatedUserInput = "q,q,5";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Assert.assertTrue(isUserInputValidRun(simulatedUserInput));
    }
    @Test
    public void runIsEmpty() {
        String simulatedUserInput = "q,q,";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Assert.assertTrue(isUserInputValidRun(simulatedUserInput));
    }
    @Test
    public void runIsNegative() {
        String simulatedUserInput = "q,q,-5";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Assert.assertFalse(isUserInputValidRun(simulatedUserInput));
    }
    @Test
    public void runIsString() {
        String simulatedUserInput = "q,q,qwe";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Assert.assertFalse(isUserInputValidRun(simulatedUserInput));
    }
//тесты на получение размера списка (должен быть числом и > 0)
    @Test
    public void shouldGetListSize() {
        String simulatedUserInput = "5";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Assert.assertEquals(5, getListSize());
    }
    @Test
    public void shouldNotGetListSize() {
        String simulatedUserInput = "Q";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Assert.assertEquals(0, getListSize());
    }
    @Test
    public void shouldNotGetListSize2() {
        String simulatedUserInput = "0\n-1\n\nk\n1\n";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Assert.assertEquals(1, getListSize());
    }
    @Test
    public void shouldNotGetListSize3() {
        String simulatedUserInput = "0";
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        Assert.assertEquals(0, getListSize());
    }

    @After
    public void tearDown() {
        System.setIn(System.in);
    }
}
