// Application lists valid shipping codes
// A, C, T, or H
// then prompts user for a code
// Application accepts a shipping code
// and determines if it is valid
import java.util.*;
public class DebugEight1
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        char userCode;
        String entry;
        boolean found = false; // initialize to false instead of true
        char[] okayCodes = {'A','C','T','H'};
        System.out.println("Enter shipping code for this delivery.");
        System.out.print("Valid codes are: ");
        
        // loop through all codes (was x < 2, now x < okayCodes.length)
        for(int x = 0; x < okayCodes.length; ++x)
        {
            System.out.print(okayCodes[x]);
            if(x != (okayCodes.length - 1))
                System.out.print(", ");
        }
        System.out.print(" >> ");
        entry = input.nextLine();
        userCode = entry.charAt(0); // get first character (index 0) instead of second character (index 1)
        
        for(int i = 0; i < okayCodes.length; ++i)
        {
            if(userCode == okayCodes[i]) // use comparison operator == instead of assignment operator =
            {
                found = true;
                break; // added break to exit loop once match is found
            }
        }
        
        // swapped the logic - if found is true, it's a good code
        if(found)
            System.out.println("Good code");
        else
            System.out.println("Sorry code not found");
            
        input.close(); 
    }
}