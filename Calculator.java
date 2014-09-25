package edu.grinnell.csc207.zuckerha17.utils;

/**
 * An implementation of a simple calculator.
 *
 * @author Ajuna Kyaruzi and Hattie Zucker
 * @Updated by Hattie Zucker, Tommy Pitcher, and Amanda Hinchman-Dominguez
 */
// credit to Sam for validating our ideas
// credit to Professor Walker for spotting a problem with braces
public class Calculator
// implements CalculatorInt
{
  // +---------+------------------------------------------------------
  // | Fields |
  // +---------+
  // declare an array that holds value assignments
  static String[] memory = { "r0", "r1", "r2", "r3", "r4", "r5", "r6", "r7" };

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  // method to compute the value of a given expression
  public static Fraction compute(String[] array)
  {
    // Make a new Fraction to hold the result
    Fraction result = new Fraction(array[0]);

    for (int j = 1; j < array.length; j++)
      {
        if ((array[j].compareTo("+")) == 0)
          {
            Fraction next = new Fraction(array[j + 1]);
            result = result.add(next);
            j++;
            // some procedure that will mutate the array
          }// if adding fractions
        if ((array[j].compareTo("-")) == 0)
          {
            Fraction next = new Fraction(array[j + 1]);
            result = result.subtract(next);
            j++;
          }// if subtracting fractions
        if ((array[j].compareTo("*")) == 0)
          {
            Fraction next = new Fraction(array[j + 1]);
            result = result.multiply(next);
            j++;
          }// if multiplying fractions
        if ((array[j].compareTo("/")) == 0)
          {
            Fraction next = new Fraction(array[j + 1]);
            result = result.divide(next);
            j++;
          }// if dividing fractions
        if ((array[j].compareTo("^")) == 0)
          {
            int next2 = Integer.parseInt(array[j + 1]);
            result = result.pow(next2);
            j++;
          }// if using exponents on fractions
      }// for loop
    return result;
  }

  public static Fraction evaluate(String expression)
    throws Exception
  {
    // Split input into array
    String[] array = expression.split(" ");
    // Check for r values that aren't followed by an "="
    for (int i = 0; i < array.length; i++)
      {
        if (array[i].charAt(0) == 'r' && array[i + 1] != "=")
          {
            array[i] = memory[Character.digit(array[i].charAt(1), 10)];
          }// if you find them, change them in the array to what is stored in
           // memory
      }// for loop

    if (array.length == 0)
      {
        return (new Fraction(0, 1));
      }// if array is empty, then return 0/1

    if (array[0].charAt(0) == 'r')
      {
        int num = Character.digit(array[0].charAt(1), 10);// num is the int
                                                          // that follows
                                                          // r immediately
        if ((num >= 0) && (num < memory.length))
          {
            if ((array[1].equals("=")) && (array.length == 3))
              {
                String newRVar = array[2]; // make a string of whatever is
                                           // assigned
                memory[num] = newRVar; // assign the string to the appropriate place in memory
                return new Fraction(memory[num]);
              }// if the next token is an equal sign, meaning an assignment
            else if (array[1] == "=" && array.length > 3)
              {
                String[] newarray = new String[array.length - 2];// declare
                                                                 // a new
                                                                 // array
                int count = 0;
                for (int i = 2; i < array.length; i++)
                  {
                    newarray[count] = array[i];
                  }//for loop to fill the array
                Fraction result = Calculator.compute(newarray);
                memory[num] = (result.toString());
                return result;
                // then set r to whatever the value of the expression is
              }// if the next token is an equal sign and it is followed by an
               // expression
          }// if num is an acceptable value
      }// if there is a memory assignment in the input
    return Calculator.compute(array);
  }// eval1 (String)
}// class Calculator
