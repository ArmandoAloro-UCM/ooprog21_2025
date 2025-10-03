// DebugFive3.java
// Determines whether item number on order is valid
// Over 999 invalid
// Less than 111 Invalid
// Valid and less than 500 - Automotive Department
// Valid and 500 or higher Housewares Department
import java.util.Scanner;
public class DebugFive3
{
    public static void main (String args[])
    {
        int item;
        String output;
        final int LOW = 111;
        final int HIGH = 999;
        final int CUTOFF = 500;
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter item number >> ");
        item = input.nextInt();
        
        // check conditions in proper order
        if(item < LOW)  // changed > to < for "too low" check
            output = "Item number too low";
        else
        if(item > HIGH)  // corrected typo HIGHH to HIGH
            output = "Item number too high";
        else
        if(item < CUTOFF)  // changed == to < for Automotive Department
            output = "Valid - Item in Automotive Department";
        else
            output = "Valid - Item in Housewares Department";
            
        System.out.println(output);
        input.close();
    }
}