import java.util.Scanner;

public class TestFraction 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.print("Enter the numerator (negative to quit): ");
            int numerator = scanner.nextInt();

            if (numerator < 0) 
            {
                System.out.println("Exiting program.");
                break;
            }

            System.out.print("Enter the denominator: ");
            int denominator = scanner.nextInt();

            if (denominator == 0) 
            {
                System.out.println("The denominator cannot be zero. Please try again.");
                continue;
            }

            Fraction fraction = new Fraction(numerator, denominator);
            System.out.print("The fraction is: ");
            fraction.printFraction();
        }
    }
}
