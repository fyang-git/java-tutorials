public class Fraction 
{
    public int numerator;
    public int denominator;

    public Fraction(int num, int denom) 
    {
        if (denom == 0) 
        {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.numerator = num;
        this.denominator = denom;
    }

    public void printFraction() 
    {
        System.out.println(this.numerator + " / " + this.denominator);
    }
}
