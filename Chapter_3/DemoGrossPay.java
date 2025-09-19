public class DemoGrossPay 
{
    public static void main(String[] args) 
    {
        calculateGross(10.0);
        calculateGross(25.0);
        calculateGross(37.5);
    }

    public static void calculateGross(double hours) 
    {
        double rate = 22.75;
        double pay = hours * rate;
        System.out.printf("%.1f hours at $%.2f per hour is $%.3f%n", hours, rate, pay);
    }
}
