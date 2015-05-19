package com.pthopa;



import com.pthopa.NumberGuesser;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.Test;

/**
 *
 * @author Prabhakar Thopa
 */
public class NumberGuesserTest {

    private final String NEW_LINE_CHAR = System.getProperty("line.separator");

    private String expected = NumberGuesser.SUCCESS_MSG;

    public NumberGuesserTest() {
    }

    /**
     * Test of guess method, of class NumberGuesser.
     * Test if the selected number is 500. In this case, the program is expected to find the number with just 1 guess
     */
    @Test
    public void testGuess500() {
        int expectedNumber= 500;
        int expectedAttempts = 1;

        StringBuilder builder = new StringBuilder("ready").append(NEW_LINE_CHAR).append("yes").append(NEW_LINE_CHAR);
        InputStream in = new ByteArrayInputStream(builder.toString().getBytes());

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baos);

        NumberGuesser instance = new NumberGuesser(in, out);
        instance.guess();

        String result = baos.toString();
        expected = String.format(expected, expectedNumber, expectedAttempts);
        System.out.println(result);
        org.junit.Assert.assertTrue(result.contains(expected));

    }


     /**
     * Test of guess method, of class NumberGuesser.
      *Test if the selected number is 7. In this case, the program is expected to find the number with 10 guesses
     */
    @Test
    public void testGuess7() {
        int expectedNumber= 7;
        int expectedAttempts = 10;

        StringBuilder builder = new StringBuilder("ready").append(NEW_LINE_CHAR)
                                .append("lower").append(NEW_LINE_CHAR)
                                .append("lower").append(NEW_LINE_CHAR)
                                .append("lower").append(NEW_LINE_CHAR)
                                .append("lower").append(NEW_LINE_CHAR)
                                .append("lower").append(NEW_LINE_CHAR)
                                .append("lower").append(NEW_LINE_CHAR)
                                .append("lower").append(NEW_LINE_CHAR)
                                .append("higher").append(NEW_LINE_CHAR)
                                .append("higher").append(NEW_LINE_CHAR)
                                .append("yes").append(NEW_LINE_CHAR);
        InputStream in = new ByteArrayInputStream(builder.toString().getBytes());

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baos);

        NumberGuesser instance = new NumberGuesser(in, out);
        instance.guess();

        String result = baos.toString();
        expected = String.format(expected, expectedNumber, expectedAttempts);
        System.out.println(result);
        org.junit.Assert.assertTrue(result.contains(expected));

    }
   

    /**
     * Test of guess method, of class NumberGuesser.
     * Test if the selected number is 1000. In this case, the program is expected to find the number with 11 guesses
     */
    @Test
    public void testGuess1000() {
        int expectedNumber= 1000;
        int expectedAttempts = 11;

        StringBuilder builder = new StringBuilder("ready").append(NEW_LINE_CHAR)
                                .append("higher").append(NEW_LINE_CHAR)
                                .append("higher").append(NEW_LINE_CHAR)
                                 .append("higher").append(NEW_LINE_CHAR)
                                .append("higher").append(NEW_LINE_CHAR)
                                 .append("higher").append(NEW_LINE_CHAR)
                                .append("higher").append(NEW_LINE_CHAR)
                                 .append("higher").append(NEW_LINE_CHAR)
                                .append("higher").append(NEW_LINE_CHAR)
                                .append("higher").append(NEW_LINE_CHAR)
                                .append("higher").append(NEW_LINE_CHAR)
                                .append("yes").append(NEW_LINE_CHAR);
        InputStream in = new ByteArrayInputStream(builder.toString().getBytes());

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baos);

        NumberGuesser instance = new NumberGuesser(in, out);
        instance.guess();

        String result = baos.toString();
        expected = String.format(expected, expectedNumber, expectedAttempts);
        System.out.println(result);
        org.junit.Assert.assertTrue(result.contains(expected));

    }

     /**
     * Test of guess method, of class NumberGuesser.
      * Test if the selected number is 1. In this case, the program is expected to find the number with just 10 guesses
     */
    @Test
    public void testGuess1() {
        int expectedNumber= 1;
        int expectedAttempts = 10;

       StringBuilder builder = new StringBuilder("ready").append(NEW_LINE_CHAR)
                                .append("lower").append(NEW_LINE_CHAR)
                                .append("lower").append(NEW_LINE_CHAR)
                                .append("lower").append(NEW_LINE_CHAR)
                                .append("lower").append(NEW_LINE_CHAR)
                                .append("lower").append(NEW_LINE_CHAR)
                                .append("lower").append(NEW_LINE_CHAR)
                                .append("lower").append(NEW_LINE_CHAR)
                                .append("lower").append(NEW_LINE_CHAR)
                                .append("lower").append(NEW_LINE_CHAR)
                                .append("yes").append(NEW_LINE_CHAR);
        InputStream in = new ByteArrayInputStream(builder.toString().getBytes());

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baos);

        NumberGuesser instance = new NumberGuesser(in, out);
        instance.guess();

        String result = baos.toString();
        expected = String.format(expected, expectedNumber, expectedAttempts);
        System.out.println(result);
        org.junit.Assert.assertTrue(result.contains(expected));

    }



     /**
     * Test of guess method, of class NumberGuesser.
      * Test if the selected number is 0. In this case, the program will ask the user to restrict selections to between the min and max allowed
      * which are 1 and 1000
     */
    @Test
    public void testGuess0() {
        int expectedNumber= 0;


       StringBuilder builder = new StringBuilder("ready").append(NEW_LINE_CHAR)
                                .append("lower").append(NEW_LINE_CHAR)
                                .append("lower").append(NEW_LINE_CHAR)
                                .append("lower").append(NEW_LINE_CHAR)
                                .append("lower").append(NEW_LINE_CHAR)
                                .append("lower").append(NEW_LINE_CHAR)
                                .append("lower").append(NEW_LINE_CHAR)
                                .append("lower").append(NEW_LINE_CHAR)
                                .append("lower").append(NEW_LINE_CHAR)
                                .append("lower").append(NEW_LINE_CHAR)
                                .append("lower").append(NEW_LINE_CHAR);
        InputStream in = new ByteArrayInputStream(builder.toString().getBytes());

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baos);

        NumberGuesser instance = new NumberGuesser(in, out);
        instance.guess();

        String result = baos.toString();
        System.out.println(result);
        org.junit.Assert.assertTrue(result.contains(NumberGuesser.OUTSIDE_RANGE_MSG));

    }

    /**
     * Test of guess method, of class NumberGuesser.
     * * Test if the selected number is 2000. In this case, the program will ask the user to restrict selections to between the min and max allowed
      * which are 1 and 1000
     */
    @Test
    public void testGuess2000() {
        int expectedNumber= 2000;


       StringBuilder builder = new StringBuilder("ready").append(NEW_LINE_CHAR)
                               .append("higher").append(NEW_LINE_CHAR)
                                .append("higher").append(NEW_LINE_CHAR)
                                 .append("higher").append(NEW_LINE_CHAR)
                                .append("higher").append(NEW_LINE_CHAR)
                                 .append("higher").append(NEW_LINE_CHAR)
                                .append("higher").append(NEW_LINE_CHAR)
                                 .append("higher").append(NEW_LINE_CHAR)
                                .append("higher").append(NEW_LINE_CHAR)
                                .append("higher").append(NEW_LINE_CHAR)
                                .append("higher").append(NEW_LINE_CHAR)
                                .append("higher").append(NEW_LINE_CHAR);
        InputStream in = new ByteArrayInputStream(builder.toString().getBytes());

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baos);

        NumberGuesser instance = new NumberGuesser(in, out);
        instance.guess();

        String result = baos.toString();
        System.out.println(result);
        org.junit.Assert.assertTrue(result.contains(NumberGuesser.OUTSIDE_RANGE_MSG));

    }

}
