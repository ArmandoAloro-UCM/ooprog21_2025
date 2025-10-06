import java.util.Scanner;

public class Payroll {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("How many hours did you work this week ? ");
        double hoursWorked = input.nextDouble();
        
        System.out.print("What is your regular pay rate ? ");
        double payRate = input.nextDouble();
        
        Employee worker = new Employee(1, payRate);
        
        double regularPay = worker.calculateRegularPay(hoursWorked);
        double overtimePay = worker.calculateOvertimePay(hoursWorked);
        
        System.out.println("Regular pay is " + regularPay);
        System.out.println("Overtime pay is " + overtimePay);
        
        input.close();
    }
}
