import java.util.Scanner;

public class Client 
{
    // Dynamic array for Change objects
    private Change[] changes; 
    // Tracks the number of valid Change objects added
    private int count; 
    
     public Client() 
     {
        changes = new Change[100]; // Initial size of array set to 100
        count = 0;
    }

    public static void main(String[] args) 
    {
        // Create an instance
        Client app = new Client();
        //Display Student info
        app.StudentInfo();
        //Start the application
        app.ClientApp();
    }
    
    // Output Student information
    private void StudentInfo()
    {
        System.out.println("Student Name: Yang Fengfan\nStudent No: 35342323\nMode of Enrolment: PT BIT BIS & CS\nTutor Name: Steven Loke");
    }

    // Run the application logic
    private void ClientApp() 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRecommendation: Please enter at least 10 records to test the program.");
        
        //preload data for testing - uncomment to call method to hardcode test data
        //hardcodeTestData();
        
        inputChanges(scanner);
        int choice;
        do 
        {
            choice = menuOptions(scanner);
            chooseMenuOption(scanner, choice);
        } 
        while (choice != 6);
        scanner.close();
    }
    
    // Method to hardcode test data, uncomment //hardcodeTestData(); to call
    private void hardcodeTestData() 
    {
        addOrUpdateChange("Ann", 85);
        addOrUpdateChange("Bob", 120);
        addOrUpdateChange("Dan", 200);
        addOrUpdateChange("Diana", 55); // Diana's total amount is 55 cents
        addOrUpdateChange("Eve", 310); // Eve's total amount is 55 cents, she has the largest amount
        addOrUpdateChange("Ann", 15); // Updates Ann's total amount to 100 cents
        addOrUpdateChange("Bob", 180);  // Updates Bob's total amount to 300 cents
        addOrUpdateChange("Dan", 50); // Updates Dan's total amount to 250 cents
        addOrUpdateChange("Fiona", 95); //Fiona's total amount is 95 cents
        addOrUpdateChange("George", 40); //George's total amount is 40 cents. he has the smallest amount
        //Total amount for all denominations: 1150 cents
        //Total coins for each denomination: $2: 3, $1: 3, 50 cents: 3, 20 cents: 4, 10 cents: 1, 5 cents: 2

    }

    // Prompt user to enter names and coin values
    private void inputChanges(Scanner scanner) 
    {
        boolean moreInput = true;
        while (moreInput && count < changes.length) 
        {
            System.out.print("Please enter the name of the person: ");
            String name = scanner.next();
            
            int coinValue = 0;
            boolean validInput = false;
            while (!validInput) 
            {
                System.out.print("Please enter the coin value for the person (multiple of 5): ");
                coinValue = scanner.nextInt();
                if (coinValue % 5 == 0) 
                {
                    validInput = true;
                } 
                else 
                {
                    System.out.println("Incorrect coin value. Must be multiple of 5.");
                }
            }
            
            addOrUpdateChange(name, coinValue);
            System.out.print("Do you have more person to enter (Y/N): ");
            moreInput = scanner.next().equalsIgnoreCase("Y");
        }
    }
    
    // Displays menu to user
    private int menuOptions(Scanner scanner) 
    {
        System.out.println("\nMenu:");
        System.out.println("1. Enter a name and display change to be given for each denomination");
        System.out.println("2. Find the name with the largest amount and display change to be given for each denomination");
        System.out.println("3. Find the name with the smallest amount and display change to be given for each denomination");
        System.out.println("4. Calculate and display the total number of coins for each denomination");
        System.out.println("5. Calculate and display the total amount for all denominations");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }
    
    // Process the user's menu selection and calls their chosen method
    private void chooseMenuOption(Scanner scanner, int choice) 
    {
        switch (choice) 
        {
            case 1:
                displayChangeForName(scanner);
                break;
            case 2:
                findAndDisplay(true); // true for largest amount
                break;
            case 3:
                findAndDisplay(false); // false for smallest amount
                break;
            case 4:
                calculateAndDisplayTotalCoins();
                break;
            case 5:
                calculateAndDisplayTotalAmount();
                break;
            case 6:
                System.out.println("Exiting program. Thank you.");
                break;
            default:
                System.out.println("Invalid choice. Please select again.");
        }
    }

    // Checks if an customer with the given name already exists and updates his/her change amount, or adds a new customer and change
    private void addOrUpdateChange(String name, int coinValue) {
        for (int counter = 0; counter < count; counter++) {
            if (changes[counter].getName().equalsIgnoreCase(name)) {
                changes[counter].addAmount(coinValue);
                return;
            }
        }
        //checks if the array is full before adding a new Change object
        if (count == changes.length) {
            increaseArraySize();
        }
        
        changes[count++] = new Change(name, coinValue);
    }
    
    // creates a new, larger array if array is full and copies the contents of the old array to the new one
    private void increaseArraySize() 
    {
        Change[] newChanges = new Change[changes.length * 2]; // Double the size of the array
        System.arraycopy(changes, 0, newChanges, 0, changes.length); // Copy existing elements to the new array
        changes = newChanges; // Set the changes reference to the new array
    }
    
    // Prompts user for a name and displays the change for the customer with that name if s/he exists
    private void displayChangeForName(Scanner scanner) 
    {
        System.out.print("Please enter the name of the person: ");
        String name = scanner.next();
        for (int counter = 0; counter < count; counter++) 
        {
            if (changes[counter].getName().equalsIgnoreCase(name)) 
            {
                System.out.println("Customer: " + name + " " + changes[counter].getTotalAmount() + " cents");
                System.out.println("Change:");
                changes[counter].displayChange();
                return;
            }
        }
        System.out.println("Name: " + name + " Not found");
    }

    // Finds and displays the name of customer with the largest or smallest total amount of money
    private void findAndDisplay(boolean largest) 
    {
        if (count == 0) 
        {
            System.out.println("No data available.");
            return;
        }

        Change result = changes[0];
        for (int counter = 1; counter < count; counter++) 
        {
            if ((largest && changes[counter].getTotalAmount() > result.getTotalAmount()) ||
                (!largest && changes[counter].getTotalAmount() < result.getTotalAmount())) 
                {
                result = changes[counter];
                }
        }

        System.out.println("Customer: " + result.getName() + " " + result.getTotalAmount() + " cents");
        System.out.println("Change:");
        result.displayChange();
    }
    
    // Calculates and displays the total number of coins for each denomination for all customers recorded in the program
    private void calculateAndDisplayTotalCoins() 
    {
        int twoDollar = 0, 
        oneDollar = 0, 
        fiftyCents = 0, 
        twentyCents = 0, 
        tenCents = 0, 
        fiveCents = 0;
        for (int counter = 0; counter < count; counter++) 
        {
            twoDollar += changes[counter].getTwoDollar();
            oneDollar += changes[counter].getOneDollar();
            fiftyCents += changes[counter].getFiftyCents();
            twentyCents += changes[counter].getTwentyCents();
            tenCents += changes[counter].getTenCents();
            fiveCents += changes[counter].getFiveCents();
        }

        System.out.println("Total coins for each denomination:");
        System.out.println("$2: " + twoDollar);
        System.out.println("$1: " + oneDollar);
        System.out.println("50 cents: " + fiftyCents);
        System.out.println("20 cents: " + twentyCents);
        System.out.println("10 cents: " + tenCents);
        System.out.println("5 cents: " + fiveCents);
    }

    // Calculates and displays the total monetary value, in cents, of all customers recorded in the system
    private void calculateAndDisplayTotalAmount() 
    {
        int totalAmount = 0;
        for (int counter = 0; counter < count; counter++)
        {
            totalAmount += changes[counter].getTotalAmount();
        }
        System.out.println("Total amount for all denominations: " + totalAmount + " cents");
    }
}

