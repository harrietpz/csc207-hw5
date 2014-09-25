package edu.grinnell.csc207.zuckerha17.utils;

import java.math.BigDecimal;

/**
 * An method for finding square roots of big decimals.
 *
 * @author Hattie Zucker, Tommy Pitcher, and Amanda Hinchman-Dominguez
 */
public class PartA
{
  // PART A
  // credit to https://github.com/Grinnell-CSC207/lab-unit-testing/
  // blob/master/src/taojava/labs/testing/SampleMethods.java for the code

  public static BigDecimal sqrt(BigDecimal d, BigDecimal epsilon)
  {
    BigDecimal approx = d; // approximation begins at d
    while (epsilon.compareTo(((d.divide(approx, 1, BigDecimal.ROUND_HALF_DOWN).subtract(approx))).abs()) == -1)
      {
        approx = (approx.add(d.divide(approx, 1, BigDecimal.ROUND_HALF_DOWN)));
        approx = (approx.divide(BigDecimal.valueOf(2)));//adjust approx appropriately
      } // while the absolute value of (d/approx)-approx is greater than epsilon
    return approx;
  } // sqrt(d, epsilon)
}
