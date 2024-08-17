import java.util.Scanner;

public class TestFraction2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fraction total = new Fraction(0, 1); // Initialize the total as 0

        while (true) {
            System.out.print("Enter the numerator (0 to finish): ");
            int numerator = scanner.nextInt();

            System.out.print("Enter the denominator (0 to finish): ");
            int denominator = scanner.nextInt();

            if (numerator == 0 && denominator == 0) {
                System.out.print("Final total is: ");
                total.printFraction();
                break;
            } else if (denominator == 0) {
                System.out.println("The denominator cannot be zero. Please try again.");
                continue;
            }

            Fraction newFraction = new Fraction(numerator, denominator);
            total = total.add(newFraction);

            System.out.print("Current total is: ");
            total.printFraction();
        }
        scanner.close();
    }
}
