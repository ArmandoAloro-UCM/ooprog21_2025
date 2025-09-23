public class DebugCircle
{
    private int radius;
    private int diameter;
    private final double PI = 3.14159;
    private double area;
    
    public DebugCircle(int r)
    {
        radius = r;
        diameter = 2 * r;
        area = PI * r * r;
    }
    
    // Removed semicolon after method declaration - methods don't end with semicolons
    public int getRadius()
    {
        // Changed "radiuss" to "radius" - fixed typo in variable name
        return radius;
    }
    
    // Changed return type from "void" to "int" since method returns an integer
    public int getDiameter()
    {
        // This method was missing proper return statement structure
        return diameter;
    }
    
    public double getArea()
    {
        return area;
    }
    
    // Added main method for testing
    public static void main(String[] args)
    {
        // Create a Circle object with radius 5
        DebugCircle circle = new DebugCircle(5);
        
        // Test the methods
        System.out.println("Circle Test Results:");
        System.out.println("Radius: " + circle.getRadius());
        System.out.println("Diameter: " + circle.getDiameter());
        System.out.println("Area: " + circle.getArea());
        
        // Create another circle with different radius
        DebugCircle circle2 = new DebugCircle(10);
        System.out.println("\nSecond Circle Test:");
        System.out.println("Radius: " + circle2.getRadius());
        System.out.println("Diameter: " + circle2.getDiameter());
        System.out.println("Area: " + circle2.getArea());
    }
}