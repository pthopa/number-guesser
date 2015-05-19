package com.pthopa;



import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Number Guessing Application.  Prompts users to think of a number between a min (1) and max (1000) range
 * and then tries to guess the selected number by prompting the user with a series of questions.
 *
 * Uses the binary search algorithm to narrow down and find the number selected by the user.
 * @author Prabhakar Thopa
 */
public class NumberGuesser {

    //Minimum allowed  number that can be selected
    public static final int MIN = 1;
    //Maximum number that can be selected
    public static final int MAX = 1000;

    private static final String REQUEST_NUMBER_MSG = "Think of a whole number between "+ MIN + " and "+ MAX +" (both inclusive). Please type \"ready\" and then press enter to indicate that the game can begin:";

    private static final String QUESTION = "Is your number %s ? Please answer with one of Yes/Lower/Higher (Please hit enter button after your answer): ";

    public static final String SUCCESS_MSG = "Yay. Guessed the number that you thought of: %d in %d attempts";

    public static final String OUTSIDE_RANGE_MSG= "Sorry, you have picked a number which is outside allowed range. Please restrict your selection  to a number between "+ MIN + " and " +MAX + " and hit enter";


    private final Scanner scanner;
    private final PrintStream out;
    private int lowerEnd = MIN;
    private int higherEnd = MAX;


    /**
     * Constructor with arguments for the input and output streams. Helps in unit testing this application code.
     * @param in Input stream to read the user's input/answers
     * @param out Output stream to write messages to the user to view on console
     */
    public NumberGuesser(InputStream in, PrintStream out) {
        this.scanner = new Scanner(in);
        this.out = out;
    }

    /**
     * Main Method
     */
    public static void main(String[] args) {
       NumberGuesser guesser = new NumberGuesser(System.in, System.out);
       guesser.guess();

    }


    /**
     * Launches the guessing game and guesses the user selected number
     */
    public void guess() {
        //First ask the user if they are ready to start the game. Keep asking them this question till they type "ready".
        String ready = "";
        do {
            out.println(REQUEST_NUMBER_MSG);
            ready = scanner.nextLine();
        }
        while("ready".equalsIgnoreCase(ready)== false);

        int count = 0;
        int guess = 0;
        String answer = null;

        //Guess a number and ask the user a question if the number they selected is equal to the guessed number or is higher/lower.
        //keep repeating this step, until the user answers yes to the guessed number, in which case print out the guessed number and the
        //number of attempts it took
        try {
                do {
                    count++;
                    int nextGuess =guessNextNumber(guess,answer);
                    if(nextGuess > 0) {
                        guess= nextGuess;
                    }
                    Object[] objArr = new Object[1];
                    objArr[0]= Integer.valueOf(guess);
                    out.println(String.format(QUESTION, objArr));
                    answer = scanner.nextLine();
                    //If user answered "end", then they want to exit the application.
                    if("end".equalsIgnoreCase(answer)) {
                    	out.println("Goodbye. Thanks for playing!");
                    	return;
                    }
                }
                while("yes".equalsIgnoreCase(answer)==false);
        }
        //If the user selected a number outside the min/max allowed range, tell the user to select a number within allowed range
        catch(IllegalArgumentException  e) {
                out.println(e.getMessage());
                return;
        }

        //print out the selected answer and the number of attempts it took to guess it
         Object[] objArr = new Object[2];
        objArr[0]= Integer.valueOf(guess);
        objArr[1]= Integer.valueOf(count);
        out.println(String.format(SUCCESS_MSG, objArr));
    }


    /**
     * Algorithm to guess the selected number. Uses binary search algorithm to narrow doen and find the selected number.
     * @param currentGuess The last guessed number
     * @param answer The answer (one of yes/lower/higher that was entered by user in response to question
     * @return The new guessed number
     */
    private int guessNextNumber(int currentGuess, String answer) {
        //to start with, use the middle of the allowed range as the guess
        if(null == answer) {
            return (MIN+MAX)/2;
        }//if the user says we have guessed their selection, we are done!
        if("yes".equalsIgnoreCase(answer)) {
            return currentGuess;
        }
        //If the user says the number they thought of is higher than what the application guessed
        else if("higher".equalsIgnoreCase(answer)) {
            //As long as what was guessed is lower than the maximum allowed, we can continue guessing
            if(MAX > currentGuess) {
                if(currentGuess == MAX-1) {
                    return MAX;
                }
                lowerEnd = currentGuess;
                return (lowerEnd+higherEnd)/2;
            }
            //If application has guessed a value which is the max allowed and the user says that their selection is higher than that,
            //it means they selected a number outside the allowed range
            else {
                throw new IllegalArgumentException(OUTSIDE_RANGE_MSG);
            }
        }
        //If the user says the number they thought of is lower than what the application guessed
        else if("lower".equalsIgnoreCase(answer)) {
            if(MIN < currentGuess) {
                if(currentGuess == MIN+1) {
                    return MIN;
                }
                higherEnd = currentGuess;
                return (lowerEnd+higherEnd)/2;
            }
            //If application has guessed a value which is the min allowed and the user says that their selection is lower than that,
            //it means they selected a number outside the allowed range
             else {
                throw new IllegalArgumentException(OUTSIDE_RANGE_MSG);
            }
        }
        else {
            return -1;
        }

    }

}

