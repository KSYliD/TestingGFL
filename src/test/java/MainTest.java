import org.example.Main;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    final public static double DELTA = 0.1;

    @Test
    public void testResolveFunction() {
        double expected = 1.0;
        double actual = Main.resolveFunction(0);
        assertEquals(expected, actual);
    }
    @Test
    public void testResolveFunction1() {
        double expected = 0.0;
        double actual = Main.resolveFunction(PI/2);
        assertEquals(expected, actual);
    }
    @Test
    public void testResolveFunction2() {
        double expected = 1.0;
        double actual = Main.resolveFunction(PI);
        assertEquals(expected, actual, DELTA);
    }
    @Test
    public void testStepNum() {
        int expected = 4;
        int actual = Main.stepNum(2, 5, 1);
        assertEquals(expected, actual);
    }
    @Test
    public void testStepNum1() {
        int expected = 11;
        int actual = Main.stepNum(5, 15, 1);
        assertEquals(expected, actual);
    }
    @Test
    public void testStepNum2() {
        int expected = 601;
        int actual = Main.stepNum(0.2, 0.5, 0.0005);
        assertEquals(expected, actual);
    }
    @Test
    public void testCreateArrayX() {
        String expected = "[2.0, 3.0, 4.0, 5.0]";
        String actual = Arrays.toString(Main.createArrayX(2, 5, 1));

        assertEquals(expected, actual);
    }
    @Test
    public void testCreateArrayX1() {
        String expected = "[0.2, 0.21, 0.22, 0.23, 0.24, 0.25, 0.26, 0.27, 0.28, 0.29, 0.3]";
        String actual = Arrays.toString(Main.createArrayX(0.2, 0.3, 0.01));
        assertEquals(expected, actual);
    }
    @Test
    public void testCreateArrayY() {
        String expected = "[0.5, 1.0]";
        String actual = Arrays.toString(Main.createArrayY(new double[]{PI / 4, PI}));
        assertEquals(expected, actual);
    }

    @Test
    public void testMaxValueNum() {
        int expected = 1;
        int actual = Main.maxValueNum(new double[]{1, 3, 2});
        assertEquals(expected, actual, DELTA);
    }
    @Test
    public void testMaxValueNum1() {
        int expected = 4;
        int actual = Main.maxValueNum(new double[]{1, 3, 2, 4,10, 7,8});
        assertEquals(expected, actual);
    }
    @Test
    public void testMinValueNum() {
        int expected = 2;
        int actual = Main.minValueNum(new double[]{3, 2, 1});
        assertEquals(expected, actual);
    }
    @Test
    public void testMinValueNum1() {
        int expected = 4;
        int actual = Main.minValueNum(new double[]{3, 2, 1, 7, 0.2, 0.5});
        assertEquals(expected, actual);
    }

    @Test
    public void testSum() {
        double expected = 15.0;
        double actual = Main.sum(new double[]{1, 2, 3, 4, 5});
        assertEquals(expected, actual);
    }
    @Test
    public void testSum1() {
        double expected = 45.0;
        double actual = Main.sum(new double[]{1, 2, 3, 4, 5, 7, 3, 15, 5});
        assertEquals(expected, actual);
    }
    @Test
    public void testAverage() {
        double expected = 3.0;
        double actual = Main.average(new double[]{2, 3, 4});
        assertEquals(expected, actual);
    }

    @Test
    public void testOutput() {
        String expected =
                """
                        max value: 1.0 step: 1 step value: 3.0
                        min value: -1.5 step: 3 step value: 5.0""";
        String actual = Main.output(2.0, 5.0, 1.0);
        assertEquals(expected, actual);
    }

}
