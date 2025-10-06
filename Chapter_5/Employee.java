class Employee {
    private int employeeNumber;
    private double payRate;
    private static final int MAX_EMPLOYEE_NUMBER = 9999;
    private static final double MAX_RATE = 60.00;
    private static final double OVERTIME_MULTIPLIER = 1.5;
    
    // Constructor
    public Employee(int empNum, double rate) {
        setEmployeeNumber(empNum);
        setPayRate(rate);
    }
    
    // Setter for employee number with validation
    public void setEmployeeNumber(int empNum) {
        if (empNum <= MAX_EMPLOYEE_NUMBER && empNum > 0) {
            this.employeeNumber = empNum;
        } else {
            this.employeeNumber = 1;
        }
    }
    
    // Setter for pay rate - removed restrictive validation
    public void setPayRate(double rate) {
        if (rate > 0) {
            this.payRate = rate;
        } else {
            this.payRate = 10.0;
        }
    }
    
    // Calculate regular pay (up to 40 hours)
    public double calculateRegularPay(double hoursWorked) {
        double regularHours = Math.min(hoursWorked, 40.0);
        return regularHours * payRate;
    }
    
    // Calculate overtime pay (hours over 40 at 1.5x rate)
    public double calculateOvertimePay(double hoursWorked) {
        if (hoursWorked > 40.0) {
            double overtimeHours = hoursWorked - 40.0;
            return overtimeHours * payRate * OVERTIME_MULTIPLIER;
        }
        return 0.0;
    }
    
    // Getters
    public int getEmployeeNumber() { 
        return employeeNumber; 
    }
    
    public double getPayRate() { 
        return payRate; 
    }
    
    public static int getMaxEmployeeNumber() { 
        return MAX_EMPLOYEE_NUMBER; 
    }
    
    public static double getMaxRate() { 
        return MAX_RATE; 
    }
    
    public static double getOvertimeMultiplier() {
        return OVERTIME_MULTIPLIER;
    }

}
