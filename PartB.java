package edu.grinnell.csc207.zuckerha17.utils;

/**
 * An iterative method for exponentiation.
 *
 * @author Hattie Zucker, Tommy Pitcher, and Amanda Hinchman-Dominguez
 */
public class PartB
{
  // PART B
  // credit to:
  // http://www.refactoring.com/catalog/replaceRecursionWithIteration.html
  public static double expt(double x, int p)
  {
    double tmp = x;//create temporary value for x

    if (p == 0)
      {
        return 1;
      } // if p is 0 return 1
    else if (p == 1)
      {
        return x;
      } // if p is 1 return x
    else
      {
        while (p > 1)
          {
            tmp *= x;
            p -= 1;
          }//while p>1
        return tmp;
      } // else if p is > 1 multiply tmp by x
  } // expt(double,int)
} // class PartB
