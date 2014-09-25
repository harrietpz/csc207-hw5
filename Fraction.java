package edu.grinnell.csc207.zuckerha17.utils;

import java.math.BigInteger;

/**
 * Class for Fraction.
 * 
 * @author Ajuna Kyaruzi and Hattie Zucker
 * @author Hattie Zucker, Tommy Pitcher, and Amanda Hinchman-Dominguez
 */
public class Fraction
{
  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+
  /** The numerator of the fraction. Can be positive, zero or negative. */
  BigInteger num;
  /** The denominator of the fraction. Must be non-negative. */
  BigInteger denom;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+ //PART A, SOME TAKEN FROM DESIGNING YOUR OWN CLASS LAB
  /**
   * Build a new fraction with numerator num and denominator denom
   *
   */
  public Fraction(BigInteger num, BigInteger denom)
  {
    this.num = num;
    this.denom = denom;
  } // Fraction(int, int)

  /**
   * Build a new fraction with numerator num and denominator denom
   *
   */
  public Fraction(int num, int denom)
  {
    this.num = BigInteger.valueOf(num);
    this.denom = BigInteger.valueOf(denom);
  } // Fraction(int, int)

  /**
   * Parse the string given to a fraction
   */
  public Fraction(String number)
  {
    int fraction = number.indexOf("/");
    if (fraction != -1)
      {
        this.num =
            BigInteger.valueOf(Integer.parseInt(number.substring(0, fraction)));
        this.denom =
            BigInteger.valueOf(Integer.parseInt(number.substring(fraction + 1)));
      }
    else
      {
        this.num = BigInteger.valueOf(Integer.parseInt(number));
        this.denom = BigInteger.ONE;
      }
  } // Fraction(String)
    // +---------+------------------------------------------------------

  // | Methods |
  // +---------+
  // Credit to Alex and Justus for telling us that we cannot do
  // modifiers in a constructor...yet

  public Fraction simplify()
  { // PART B
    BigInteger resultNum;
    BigInteger resultDenom;
    BigInteger GCD = this.num.gcd(this.denom);
    resultNum = this.num.divide(GCD);
    resultDenom = this.denom.divide(GCD);
    if (resultDenom.compareTo(BigInteger.valueOf(0)) < 0)
      {
        resultNum = resultNum.multiply(BigInteger.valueOf(-1));
        resultDenom = resultDenom.multiply(BigInteger.valueOf(-1));
      }// if
    if (this.num == BigInteger.valueOf(0))
      {
        this.denom = BigInteger.valueOf(1);
      }// if
    return new Fraction(resultNum, resultDenom);
  }// simplify()

  public Fraction negate()
  { // PART A
    BigInteger resultNum;
    BigInteger resultDenom;
    resultNum = this.num.negate();
    resultDenom = this.denom;
    return new Fraction(resultNum, resultDenom).simplify();
  }// negate

  /**
   *
   * Multiply two fractions
   */
  public Fraction multiply(Fraction multiplicand)
  { // PART A
    BigInteger resultNumerator;
    BigInteger resultDenominator;
    resultDenominator = this.denom.multiply(multiplicand.denom);
    resultNumerator = this.num.multiply(multiplicand.num);
    return new Fraction(resultNumerator, resultDenominator).simplify();
  }// multiply(Fraction)

  /**
   * Add the fraction other to this fraction
   */
  public Fraction add(Fraction addMe)
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;
    // The denominator of the result is the
    // product of this object's denominator
    // and addMe's denominator
    resultDenominator = this.denom.multiply(addMe.denom);
    // The numerator is more complicated
    resultNumerator =
        (this.num.multiply(addMe.denom)).add(addMe.num.multiply(this.denom));
    // Return the computed value
    return new Fraction(resultNumerator, resultDenominator).simplify();
  }// add(Fraction)

  /**
   * Subtract the fraction other from this fraction
   */
  public Fraction subtract(Fraction subtrahend)
  { // PART A
    BigInteger resultNum;
    BigInteger resultDenom;
    resultNum =
        this.num.multiply(subtrahend.denom)
                .subtract(subtrahend.num.multiply(this.denom));
    // make sure that the denominators match
    resultDenom = this.denom.multiply(subtrahend.denom);
    return new Fraction(resultNum, resultDenom).simplify();
  }// subtract(Fraction)

  public Fraction divide(Fraction divisor)
  { // PART A
    Fraction flipper = new Fraction(divisor.denom, divisor.num);
    return this.multiply(flipper).simplify();
  }// divide(Fraction)

  /**
   * Apply powers to fractions
   */
  public Fraction pow(int expt)
  { // PART A
    BigInteger resultNum;
    BigInteger resultDenom;
    if (expt < 0)
      { // if the exponent is negative
        int newExpt = expt * -1;
        resultNum = this.denom.pow(newExpt);
        resultDenom = this.num.pow(newExpt);
      }// if
    else
      { // otherwise apply the power function normally
        resultNum = this.num.pow(expt);
        resultDenom = this.denom.pow(expt);
      }// else
    return new Fraction(resultNum, resultDenom).simplify();
  }// pow(int)

  /**
   * Convert this fraction to a string for ease of printing
   */
  public String toString()
  {
    // Special case: It's zero
    if (this.num.equals(BigInteger.ZERO))
      {
        return "0";
      } // if it's zero
        // Lump together the string represention of the numerator,
    // a slash, and the string representation of the denominator
    // return
    // this.num.toString().concat("/").concat(this.denom.toString());
    return this.num + "/" + this.denom;
  } // toString()
} // class Fraction
