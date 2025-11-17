// Makes String comparisons
import java.util.*;
public class DebugSeven1
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        String name1, name2, name3;
        System.out.println("Enter three names.");
        System.out.println("They can be the same or different.");
        System.out.print("First name >> ");
        name1 = kb.nextLine(); // added parentheses to call nextLine() method
        System.out.print("Second name >> ");
        name2 = kb.nextLine(); // added parentheses to call nextLine() method
        System.out.print("Third name >> ");
        name3 = kb.nextLine(); // added parentheses to call nextLine() method
        compareNames(name1, name2);
        compareNames(name1, name3);
        compareNames(name2, name3);
        kb.close(); // added to close Scanner resource and prevent resource leak
    }
    
    // method name was "comparNames", corrected to "compareNames" to match the calls
    // added proper parameter syntax with String type for n2
    public static void compareNames(String n1, String n2)
    {
        System.out.print(n1 + " and " + n2);
        if(n1.equals(n2)) // added missing closing parenthesis
            System.out.println(" are the same");
        else
            System.out.println(" are different");
    }
}