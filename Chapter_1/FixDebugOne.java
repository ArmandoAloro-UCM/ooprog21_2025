/*   Buggy Version 
public class FixDebug One 
{ 
    // This program displays a greeting 
    public static void Main(String args) 
    { 
        Systm.out.println("Hello World!") 
    } 
    
    
     // List down the spotted bugs below:
     // 1. Invalid class name - "FixDebug One" class names cannot have spaces.
     // 2. Wrong main method signature - "Main" should be lowercase "main" and should use String[]args.
     // 3. Typo in "System" - written as "Systm".
     // 4. Missing semicolon - after System.out.println("Hello World!").
    
}
*/

// Fixed Version
public class FixDebugOne 
{ 
    /* This program displays a greeting */ 
    public static void main(String[]args) 
    { 
        System.out.println("Hello World!"); 
    } 
}

