// This class uses a DebugBox class
// to instantiate two Box objects
import java.util.Scanner;
public class DebugFour3
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int w, l, h;
        System.out.print("Enter width of box >> ");
        w = input.nextInt();  // was input.nextInteger()
        System.out.print("Enter length of box >> ");
        l = input.nextInt();  // was input.nextDouble() and l should be int
        System.out.print("Enter height of box >> ");
        h = input.nextInt();
        DebugBox box1 = new DebugBox();  // was FixDebugBox
        DebugBox box2 = new DebugBox(w, l, h);  // was box1 and FixDebugBox
        System.out.println("The dimensions of the first box are");
        box1.showData();
        System.out.print(" The volume of the first box is ");
        showVolume(box1);
        System.out.println("The dimensions of the second box are");
        box2.showData();
        System.out.print(" The volume of the second box is ");
        showVolume(box2);  // was box2.showVolume()
        input.close();
    }
    
    public static void showVolume(DebugBox aBox)
    {
        double vol = aBox.getVolume();
        System.out.println(vol);
    }
}