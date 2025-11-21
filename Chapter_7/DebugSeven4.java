// Gets a String from user
// Converts the String to lowercase, and
// displays the String's length
// as well as a count of letters
import java.util.*;
public class DebugSeven4
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        String aString;
        int numLetters = 0;
        int stringLength;
        System.out.println("Enter a String. Include");
        System.out.println("some uppercase letters, lowercase");
        System.out.print("letters, and numbers >> ");
        aString = kb.nextLine();
        stringLength = aString.length();
        System.out.print("In all lowercase, the String is: ");
        for(int i = 0; i < stringLength; i++)  // loop was 'i <= stringLength', which goes out of bounds (string indices are 0 to length-1); changed to 'i < stringLength'
        {
            char ch = Character.toLowerCase(aString.charAt(i));  // 'aStringcharAt(i)' was missing a dot; added '.' to make it 'aString.charAt(i)'
            System.out.print(ch);
            if(Character.isLetter(ch))  // this was '!Character.isLetter(ch)', which counts non-letters, but the output says "number of LETTERS"; inverted to count letters
                numLetters++;
        }
        System.out.println();
        System.out.println("The number of CHARACTERS in the string is " + stringLength);  // this was already correct
        System.out.println("The number of LETTERS is " + numLetters);  //  missing opening quote before '+'; added '"' and fixed closing quote/parenthesis 
    }
}