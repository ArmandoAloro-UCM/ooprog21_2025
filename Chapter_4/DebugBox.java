public class DebugBox
{
    private int width;
    private int length;
    private int height;
    
    public DebugBox()
    {
        length = 1;
        width = 1;
        height = 1;
    }
    
    // constructor was assigning width to all three variables
    public DebugBox(int width, int length, int height)
    {
        this.width = width;
        this.length = length;    // was "this.length = width;"
        this.height = height;    // was "this.height = width;"
    }
    
    public void showData()
    {
        System.out.println("Width: " + width + " Length: " +
                          length + " Height: " + height);
    }
    
    public double getVolume()
    {
        double vol = length * width * height;
        return vol;
    }
    
}