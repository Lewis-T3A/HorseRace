import java.awt.*;
import javax.swing.*;
public class HorseCustom {
    public HorseCustom(int laneCount)
    {
        JFrame frame2 = new JFrame ( "Horse Customisation");
        frame2.setSize(600,400);
        JPanel panel2 = new JPanel ();
        panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComboBox<String>[]breedChooser = new JComboBox[laneCount];
        JComboBox<String>[]colourChooser = new JComboBox[laneCount];
        JTextField[] symbolInput = new JTextField[laneCount];
        JComboBox<String>[]saddleChooser = new JComboBox[laneCount];
        JComboBox<String>[]horseshoeChooser = new JComboBox[laneCount];
        JComboBox<String>[]accessoryChooser = new JComboBox[laneCount];

        for ( int i = 0; i<laneCount;i++)
        {
            JPanel panelrow = new JPanel(new GridLayout(2,6,10,10));
            panelrow.add(new JLabel ("Breed:"));
            panelrow.add(new JLabel (""));
            panelrow.add(new JLabel (""));
            panelrow.add(new JLabel (""));
            panelrow.add(new JLabel (""));
            panelrow.add(new JLabel (""));
            
            //Horse Breed
            
            breedChooser[i] = new JComboBox<>(new String[]{"Arabian","Thoroughbred","Quarter Horse"});

            //Coat Colour
            
            colourChooser[i] = new JComboBox<>( new String[]{"Brown", "White","Black","Red","Golden","Spotted"});
            
            //Symbol label and input
            
            symbolInput[i] = new JTextField(1);
            
            //Equipment and Accessories
            
            //Saddle colour
            
            saddleChooser[i] = new JComboBox<> (new String[]{"Black","White","Gold","Red","Blue"});

            //HorseShoe type
            
            horseshoeChooser[i] = new JComboBox<>(new String[]{"Light","Heavy","Regular"});

            //Accessory

            
            accessoryChooser[i] = new JComboBox<>(new String[]{"none","Hat","Blanket","Birdle"});
            
  

        panel2.add(panelrow);
        }
       
        frame2.add(panel2);
        frame2.setVisible(true);
       
    }

    
    public static void main(String[] args) {
        new HorseCustom(3); // test with 3 horses
    }
}
