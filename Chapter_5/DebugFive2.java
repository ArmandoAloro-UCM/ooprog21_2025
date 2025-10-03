// DebugFive2.java
// Decides if two numbers are evenly divisible
import java.util.Scanner;
public class DebugFive2
{
    public static void main(String args[])
    {
        int num;
        int num2;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number ");
        num = input.nextInt(); // added parentheses for method call
        System.out.print("Enter another number ");
        num2 = input.nextInt(); // added parentheses for method call
        
        // changed division to modulo and AND to OR
        // check if num is divisible by num2 OR num2 is divisible by num
        if((num % num2 == 0) || (num2 % num == 0))
        {
            System.out.println("One of these numbers is");
            System.out.println(" evenly divisible into the other");
        }
        else
        { 
            System.out.println("Neither of these numbers is");
            System.out.println(" evenly divisible into the other");
        }
        
        input.close(); 
    }
}