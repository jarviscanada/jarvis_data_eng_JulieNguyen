package ca.jrvs.apps.practice;

import org.junit.*;
import java.io.*;
import java.util.*;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaStreamExcImpTest {

    LambdaStreamExcImp lambdaStream;

    @Before
    public void setUp() throws Exception {
        lambdaStream = new LambdaStreamExcImp();
    }

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @Before
    public void setStreams() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void restoreInitialStreams() {
        System.setOut(originalOut);
    }
    @Test
    public void createStrStream() {
    }

    @Test
    public void toUpperCase() {
    }

    @Test
    public void filter() {
    }

    @Test
    public void createIntStream() {
    }

    @Test
    public void toList() {
    }

    @Test
    public void testToList() {
        List<Integer> expected = new ArrayList<Integer>();
        IntStream intStream = IntStream.of(1, 2, 3);
        expected.add(1);
        expected.add(2);
        expected.add(3);

        Assert.assertEquals(expected, lambdaStream.toList(intStream));
    }

    @Test
    public void testCreateIntStream() {
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        Assert.assertEquals(expected, lambdaStream.toList(lambdaStream.createIntStream(1, 4)));
    }

    @Test
    public void squareRootIntStream() {
        List<Double> expected = new ArrayList<Double>();
        IntStream intStream = IntStream.of(1, 4, 9);
        expected.add(1.0);
        expected.add(2.0);
        expected.add(3.0);

        Assert.assertEquals(expected, lambdaStream.toList(lambdaStream.squareRootIntStream(intStream).boxed()));
    }

    @Test
    public void getOdd() {
        List<Integer> expected = new ArrayList<Integer>();
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5, 6);
        expected.add(1);
        expected.add(3);
        expected.add(5);

        Assert.assertEquals(expected, lambdaStream.toList(lambdaStream.getOdd(intStream)));
    }

    @Test
    public void getLambdaPrinter() {
    }

    @Test
    public void printMessages() {
    }

    @Test
    public void printOdd() {
    }

    @Test
    public void flatNestedInt() {
    }
}
