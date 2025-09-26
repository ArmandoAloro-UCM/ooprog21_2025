public class DebugPen
{
    private String color;
    private String point;
    
    public DebugPen()
    {
        color = "black";
        point = "fine";
    }
    
    // Constructor parameters were not assigned to instance variables
    public DebugPen(String color, String point)
    {
        this.color = color;    // was "color = color;"
        this.point = point;    // was "point = point;"
    }
    
    public String getColor()
    {
        return color;
    }
    
    public String getPoint()
    {
        return point;
    }
}