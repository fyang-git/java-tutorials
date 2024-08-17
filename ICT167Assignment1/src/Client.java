import java.util.Scanner;

public class Client 
{
    //dynamic array for Change objects
    private Change[] changes; 
    //tracks the number of valid Change objects added
    private int count; 
    
     public Client() 
     {
        changes = new Change[100]; //set initial size of array to 100
        count = 0;
    }

    public static void main(String[] args) 
    {
        //create an instance
        Client app = new Client();
        //display Student info
        app.StudentInfo();
        //Start the application
        app.ClientApp();
    }
    
    //output Student information
    private void StudentInfo()
    {
        System.out.println("Student Name: Yang Fengfan\nStudent No: 35342323\nMode of Enrolment: PT BIT BIS & CS\nTutor Name: Steven Loke");
    }

    //run the application logic
    private void ClientApp() 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRecommendation: Please enter at least 10 records to test the program.");
        
        //preload data for testing - uncomment to call method to hardcode test data
        hardcodeTestData();
        
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
    
    //method to hardcode test data, uncomment "hardcodeTestData();" in ClientApp method to call
    private void hardcodeTestData() 
    {
        addOrUpdateChange("Ann", 85);
        addOrUpdateChange("Bob", 120);
        addOrUpdateChange("Dan", 200);
        addOrUpdateChange("Diana", 55); //Diana's total amount is 55 cents
        addOrUpdateChange("Eve", 310); //Eve's total amount is 55 cents, she has the largest amount
        addOrUpdateChange("Ann", 15); //updates Ann's total amount to 100 cents
        addOrUpdateChange("Bob", 180);  //updates Bob's total amount to 300 cents
        addOrUpdateChange("Dan", 50); //updates Dan's total amount to 250 cents
        addOrUpdateChange("Fiona", 95); //Fiona's total amount is 95 cents
        addOrUpdateChange("George", 40); //George's total amount is 40 cents. he has the smallest amount
        //total amount for all denominations: 1150 cents
        //total coins for each denomination: $2: 3, $1: 3, 50 cents: 3, 20 cents: 4, 10 cents: 1, 5 cents: 2

    }

    //prompt user to enter names and coin values
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
    
    //displays menu to user
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
    
    //process the user's menu selection and call their chosen method
    private void chooseMenuOption(Scanner scanner, int choice) 
    {
        switch (choice) 
        {
            case 1:
                displayChangeForName(scanner);
                break;
            case 2:
                findAndDisplay(true); //true for largest amount
                break;
            case 3:
                findAndDisplay(false); //false for smallest amount
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

//check if a customer with the given name exists and update their change amount, if not, add a new customer and change
private void addOrUpdateChange(String name, int coinValue) 
{
    int counter = 0;
    while (counter < count)
    {
        if (changes[counter].getName().equalsIgnoreCase(name))
        {
            changes[counter].addAmount(coinValue);
            return;
        }
        counter++;
    }
    //check if the array is full before adding a new Change object
    if (count == changes.length)
    {
        increaseArraySize();
    }
    changes[count++] = new Change(name, coinValue);
}

    
    //creates a larger array if array is full and copy old array to new array
    private void increaseArraySize() 
    {
        Change[] newChanges = new Change[changes.length * 2]; //double the size of the array
        System.arraycopy(changes, 0, newChanges, 0, changes.length); //copy elements in old array to new array
        changes = newChanges; //set the changes reference to the new array
    }
    
//prompts user for a name and display the change for the customer with that name if it exists
private void displayChangeForName(Scanner scanner)
{
    System.out.print("Please enter the name of the person: ");
    String name = scanner.next();
    int counter = 0;
    while (counter < count)
    {
        if (changes[counter].getName().equalsIgnoreCase(name)) 
        {
            System.out.println("Customer: " + name + " " + changes[counter].getTotalAmount() + " cents");
            System.out.println("Change:");
            changes[counter].displayChange();
            return;
        }
        counter++;
    }
    System.out.println("Name: " + name + " Not found");
}


//find and display name of the customer with largest or smallest total amount of money
private void findAndDisplay(boolean largest) 
{
    if (count == 0) 
    {
        System.out.println("No data available.");
        return;
    }

    Change result = changes[0];
    int counter = 1;
    while (counter < count)
    {
        if ((largest && changes[counter].getTotalAmount() > result.getTotalAmount()) ||
            (!largest && changes[counter].getTotalAmount() < result.getTotalAmount()))
            {
                result = changes[counter];
            }
        counter++;
    }

    System.out.println("Customer: " + result.getName() + " " + result.getTotalAmount() + " cents");
    System.out.println("Change:");
    result.displayChange();
}

    
//calculate and display the total number of coins for each denomination for all customers recorded in the program
private void calculateAndDisplayTotalCoins() 
{
    int twoDollar = 0,
        oneDollar = 0,
        fiftyCents = 0,
        twentyCents = 0,
        tenCents = 0,
        fiveCents = 0;
    int counter = 0;
    while (counter < count) 
    {
        twoDollar += changes[counter].getTwoDollar();
        oneDollar += changes[counter].getOneDollar();
        fiftyCents += changes[counter].getFiftyCents();
        twentyCents += changes[counter].getTwentyCents();
        tenCents += changes[counter].getTenCents();
        fiveCents += changes[counter].getFiveCents();
        counter++;
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
    int counter = 0;
    while (counter < count) 
    {
        totalAmount += changes[counter].getTotalAmount();
        counter++;
    }
    System.out.println("Total amount for all denominations: " + totalAmount + " cents");
}

}

