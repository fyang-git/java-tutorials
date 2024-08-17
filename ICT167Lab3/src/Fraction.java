public class Fraction 
{
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) 
    {
        if (denominator == 0) 
        {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        // If the denominator is negative, change signs of both numerator and denominator.
        if (denominator < 0) 
        {
            numerator *= -1;
            denominator *= -1;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() 
    {
        return numerator;
    }

    public int getDenominator() 
    {
        return denominator;
    }

    public void printFraction() 
    {
        System.out.println(numerator + " / " + denominator);
    }
}
