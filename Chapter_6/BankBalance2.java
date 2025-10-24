import java.util.Scanner; 

public class BankBalance2 
{
    public static void main(String[] args) 
    {
        Scanner inputScanner = new Scanner(System.in);
        
        System.out.print("Enter initial bank balance > ");
        double initialBankBal = inputScanner.nextDouble();
        
        double annualInterRate = 0.03;
        
        double currentBal = initialBankBal;
        int currentYear = 0;
        int userChoice;
        
        do 
        {
            System.out.println("\nDo you want to see the balance at the end of another year? \nEnter 1 for yes");
            System.out.print("    or any other number for no >> ");
            userChoice = inputScanner.nextInt();
            
            if (userChoice == 1) 
            {
                currentYear++;
                currentBal = currentBal * (1 + annualInterRate);
                System.out.println("After year " + currentYear + " at " + annualInterRate);
                System.out.println("interest rate, balance is $" + currentBal);
            }
            
        } while (userChoice == 1);
        
        inputScanner.close();
    }
}
