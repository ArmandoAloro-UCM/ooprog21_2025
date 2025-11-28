import java.util.Arrays;

public class ArraysDemo 
{
    public static void display(String message, int array[]) 
    {
        System.out.print(message + "    ");
        for (int i = 0; i < array.length; i++) 
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) 
    {

        int[] nums = {0, 0, 0, 0, 0};

        display("Original array:           ", nums);

        nums = new int[]{8, 8, 8, 8, 8, 8};
        display("After filling with 8s:    ", nums);

        nums[2] = 6;
        nums[4] = 3;
        display("After changing two values:", nums);

        Arrays.sort(nums);
        display("After sorting:            ", nums);
    }
}

