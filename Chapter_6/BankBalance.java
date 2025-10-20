import java.util.Scanner; 

public class BankBalance 
{
    public static void main(String[] args) 
    {
        Scanner inputScanner = new Scanner(System.in);
        
        System.out.print("Enter initial bank balance > ");
        double initialBankBal = inputScanner.nextDouble();
        
        double annualInterRate = 0.03;
        
        double currentBal = initialBankBal;

        int currentYear = 0;
        
        System.out.println("Do you want to see next year's balance? ");
        System.out.print("Enter 1 for yes    or any other number for no>> ");
        int userChoice = inputScanner.nextInt();
        
        
        while (userChoice == 1) 
        {
            currentYear++;
            
            currentBal = currentBal * (1 + annualInterRate);
            
            System.out.println("After year " + currentYear + " at " + annualInterRate + " interest rate, the balance is $" + currentBal );
             
            System.out.println("\nDo you want to see the balance at the end of another year? ");
            System.out.print("Enter 1 for yes    or any other number for no >> ");
            userChoice = inputScanner.nextInt();
        }
        
        inputScanner.close();
    }
}