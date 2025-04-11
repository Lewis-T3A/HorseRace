import javax.swing.*;
public class RaceGUI extends JFrame
{
    private JComboBox<String> shapeBox;

    public RaceGUI()
    {
        setTitle("Horse Race");
        setSize(400,400);
        
    }
    
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> new RaceGUI());
    }
}
