import javax.swing.JOptionPane;

public class UsingJOptionPaneDialogs 
{
    public static void main(String[]args) 
    {
        while (true) 
        {
            String name = JOptionPane.showInputDialog("Enter your name:");

            if (name == null) 
            { 
                break;
            }

            int confirm = JOptionPane.showConfirmDialog(null, "Do you want your name to be shown?");
            if (confirm == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Hello " + name);

                int proceed = JOptionPane.showConfirmDialog(null, "Do you want to proceed?", "Proceed", JOptionPane.YES_NO_OPTION);
                if (proceed == JOptionPane.YES_OPTION) 
                {
                    
                }
                break; 
            }
        }
    }
}

