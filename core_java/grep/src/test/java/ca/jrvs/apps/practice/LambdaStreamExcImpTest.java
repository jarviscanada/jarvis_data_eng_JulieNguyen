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
    public void toUpperCase() {
        List<String> expected = new ArrayList<String>();
        expected.add("HELLO");
        expected.add("WORLD");

        Assert.assertEquals(expected, lambdaStream.toUpperCase("Hello","World").collect(Collectors.toList()));
    }

    @Test
    public void filter() {
        Stream<String> expected = Stream.of("explain", "expo");
        Stream<String> stream = Stream.of("explain", "expo", "easy");
        String pattern = "x";

        Assert.assertEquals(lambdaStream.toList(expected), lambdaStream.toList(lambdaStream.filter(stream, pattern)));
    }

    @Test
    public void testToList() {
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        IntStream intStream = IntStream.of(1, 2, 3);

        Assert.assertEquals(expected, lambdaStream.toList(intStream));
    }

    @Test
    public void testCreateIntStream() {
        Stream<Integer> expected = Stream.of(1, 2 ,3);

        Assert.assertEquals(lambdaStream.toList(expected), lambdaStream.toList(lambdaStream.createIntStream(1, 4)));
    }

    @Test
    public void squareRootIntStream() {
        Stream<Double> expected = Stream.of(1.0, 2.0, 3.0);
        IntStream intStream = IntStream.of(1, 4, 9);

        Assert.assertEquals(lambdaStream.toList(expected), lambdaStream.toList(lambdaStream.squareRootIntStream(intStream).boxed()));
    }

    @Test
    public void getOdd() {
        Stream<Integer> expected = Stream.of(1, 3, 5);
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5, 6);

        Assert.assertEquals(lambdaStream.toList(expected), lambdaStream.toList(lambdaStream.getOdd(intStream)));
    }

    @Test
    public void printMessages() {
        String [] messages = {"a", "b", "c"};
        lambdaStream.printMessages(messages, lambdaStream.getLambdaPrinter("msg:", "!"));
        String expected = "msg:a!\n" +
                "msg:b!\n" +
                "msg:c!\n";
        Assert.assertEquals(expected, out.toString());
    }

    @Test
    public void printOdd() {
        lambdaStream.printOdd(lambdaStream.createIntStream(0, 6), lambdaStream.getLambdaPrinter("odd number:", "!"));
        String expected = "odd number:1!\n" +
                "odd number:3!\n" +
                "odd number:5!\n";
        Assert.assertEquals(expected, out.toString());
    }

    @Test
    public void flatNestedInt() {
        Stream<Integer> expected = Stream.of(1, 4, 9);

        List<Integer> ints = new ArrayList<Integer>();
        ints.add(1);
        ints.add(2);
        ints.add(3);

        Stream<List<Integer>> input = Stream.of(ints);

        Assert.assertEquals(lambdaStream.toList(expected), lambdaStream.toList(lambdaStream.flatNestedInt(input)));
    }
}
