import java.util.Scanner;

public class BankBalanceByRateAndYear
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter initial balance > ");
        double initialBal = scanner.nextDouble();
        
        double[] interestRates = {0.02, 0.03, 0.04, 0.05};
        
        for (int rateIndex = 0; rateIndex < interestRates.length; rateIndex++) 
        {
            double currentBal = initialBal;
            double rate = interestRates[rateIndex];
            
            System.out.println("\nwith an initial balance of $" + initialBal + " at an interest rate of " + rate);
            
            for (int year = 1; year <= 4; year++) 
            {
                currentBal = currentBal * (1 + rate);
                System.out.println("After year " + year + " balance is $" + currentBal);
            }
            
            System.out.println(); 
        }
        
        scanner.close();
    }
}