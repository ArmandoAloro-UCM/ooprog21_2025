// Program accepts a String and displays some facts
import java.util.*;
public class DebugSeven3
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        String quote, charString;
        char searchChar;
        System.out.print("Enter a famous quote >> ");
        quote = kb.nextLine();  // 'nextLine()' was called without an object; changed to 'kb.nextLine()' to read from the Scanner
        System.out.print("Enter a character to search for >> ");
        charString = kb.nextLine();  // 'kb.nextInt()' reads an int, but we need a string to extract a char; changed to 'kb.nextLine()' for string input
        searchChar = charString.charAt(0);
        System.out.println("index of('" + searchChar + "') is: " +
            quote.indexOf(searchChar));  // missing closing parenthesis after 'searchChar'; added ')' to close the println
        System.out.println("indexOf('a') is: " + quote.indexOf('a'));  // missing opening parenthesis before 'a'; added '
        System.out.println("indexOf('x') is: " + quote.indexOf('x'));  // this was already correct
        System.out.println("charAt(5) is: " + quote.charAt(5));  // this was already correct
        System.out.println("replace('e', '*') is: " +
            quote.replace('e', '*'));  // 'repplace' is a typo; changed to 'replace' 
    }
}