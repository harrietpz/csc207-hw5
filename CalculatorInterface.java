package edu.grinnell.csc207.zuckerha17.utils;

/**
/**
 * An interface for a simple calculator.
 *
 * @author Hattie Zucker, Tommy Pitcher, and Amanda Hinchman-Dominguez
 */
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

//credit to Sam for validating our ideas and helping us to organize the interface
//Credit to Professor Walker for helping find the nextLine procedure
public class CalculatorInterface
{
  public static void main(String[] args)
    throws Exception
  {
    PrintWriter pen = new PrintWriter(System.out, true);
    pen.println(Arrays.toString(Calculator.memory));
    Scanner user_input = new Scanner(System.in);
    String input;
    pen.println("Please enter a mathematical expression or type \"quit\" "
                + "to exit the program: ");
    input = user_input.nextLine();
    while (true)
      {
        if (input.equalsIgnoreCase("quit"))
          {
            user_input.close();
          }
        else
          {
            // Send the input to the calculator's evaluate method
            pen.println("Output: " + Calculator.evaluate(input));
            pen.println(Arrays.toString(Calculator.memory));
            pen.println("Please enter a mathematical expression or type \"quit\" "
                        + "to exit the program: ");
            input = user_input.nextLine();
          }
      } // while

  } // main(String[])
} // class CalculatorInt
