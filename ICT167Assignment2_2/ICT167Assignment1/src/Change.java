// Declare class Change
class Change 
{
    // Declare attributes
    private String name;
    private int totalAmount;
    private int twoDollar;
    private int oneDollar;
    private int fiftyCents;
    private int twentyCents;
    private int tenCents;
    private int fiveCents;

    // Getters
    public String getName() 
        {
            return name;
        }
         public int getTwoDollar() 
        {
            return twoDollar;
        }
    
        public int getOneDollar() 
        {
            return oneDollar;
        }
    
        public int getFiftyCents() 
        {
            return fiftyCents;
        }
    
        public int getTwentyCents() 
        {
            return twentyCents;
        }
    
        public int getTenCents() 
        {
            return tenCents;
        }
    
        public int getFiveCents() 
        {
            return fiveCents;
        }
        
         public int getTotalAmount() 
         {
        return totalAmount;
         }
    
    // Setters
    public Change(String name, int totalAmount) 
    {
        this.name = name;
        this.totalAmount = totalAmount;
        calculateChange();
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public void setTotalAmount(int totalAmount) 
    {
        this.totalAmount = totalAmount;
        calculateChange();
    }

    public void addAmount(int amount) 
    {
        this.totalAmount += amount;
        calculateChange();
    }
    
    // Initialise variables to default values
    public Change() 
    {
        this.name = "";
        this.totalAmount = 0;
        
        this.twoDollar = 0;
        this.oneDollar = 0;
        this.fiftyCents = 0;
        this.twentyCents = 0;
        this.tenCents = 0;
        this.fiveCents = 0;
    }
    
    // Method to calculate breakdown of the total amount into coin denominations
    private void calculateChange() 
    {
        int remainingAmount = totalAmount;
        twoDollar = remainingAmount / 200;
        remainingAmount %= 200;
        oneDollar = remainingAmount / 100;
        remainingAmount %= 100;
        fiftyCents = remainingAmount / 50;
        remainingAmount %= 50;
        twentyCents = remainingAmount / 20;
        remainingAmount %= 20;
        tenCents = remainingAmount / 10;
        remainingAmount %= 10;
        fiveCents = remainingAmount / 5;
    }

    // Method to display the coin breakdown for a customer
    public void displayChange() 
    {
        if (twoDollar > 0) System.out.println("$2: " + twoDollar);
        if (oneDollar > 0) System.out.println("$1: " + oneDollar);
        if (fiftyCents > 0) System.out.println("50 cents: " + fiftyCents);
        if (twentyCents > 0) System.out.println("20 cents: " + twentyCents);
        if (tenCents > 0) System.out.println("10 cents: " + tenCents);
        if (fiveCents > 0) System.out.println("5 cents: " + fiveCents);
    }
    
}