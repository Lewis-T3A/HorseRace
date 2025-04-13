import java.awt.*;
import javax.swing.*;
public class HorseCustom {
    public HorseCustom(int laneCount)
    {
        JFrame frame2 = new JFrame ( "Horse Customisation");
        frame2.setSize(600,400);
        JPanel panel2 = new JPanel (new GridLayout(laneCount + 1,6,10,10));
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComboBox<String>[]breedChooser = new JComboBox[laneCount];
        JComboBox<String>[]colourChooser = new JComboBox[laneCount];
        JTextField[] symbolInput = new JTextField[laneCount];
        JComboBox<String>[]saddleChooser = new JComboBox[laneCount];
        JComboBox<String>[]horseshoeChooser = new JComboBox[laneCount];
        JComboBox<String>[]accessoryChooser = new JComboBox[laneCount];

        for ( int i = 0; i<laneCount;i++)
        {
            //Horse Breed
            JLabel horseBreed = new JLabel("Horse Breed");
            breedChooser[i] = new JComboBox<>(new String[]{"Arabian","Thoroughbred","Quarter Horse"});

            //Coat Colour
            JLabel horseColour = new JLabel ( "Coat Colour");
            colourChooser[i] = new JComboBox<>( new String[]{"Brown", "White","Black","Red","Golden","Spotted"});
            
            //Symbol label and input
            JLabel horseSymbol = new JLabel ( "Horse Symbol ");
            symbolInput[i] = new JTextField(1);
            
            //Equipment and Accessories
            
            //Saddle colour
            JLabel saddleColour = new JLabel("Saddle:");
            saddleChooser[i] = new JComboBox<> (new String[]{"Black","White","Gold","Red","Blue"});

            //HorseShoe type
            JLabel horseShoeLabel = new JLabel ("HorseShoes:");
            horseshoeChooser[i] = new JComboBox<>(new String[]{"Light","Heavy","Regular"});

            //Accessory

            JLabel accessoryLabel = new JLabel("Accessory:");
            accessoryChooser[i] = new JComboBox<>(new String[]{"none","Hat","Blanket","Birdle"});
            
            panel2.add(horseBreed);
            panel2.add(breedChooser[i]);
            panel2.add(horseColour);
            panel2.add(colourChooser[i]);
            panel2.add(horseSymbol);
            panel2.add(symbolInput[i]);
            panel2.add(saddleColour);
            panel2.add(saddleChooser[i]);
            panel2.add(horseShoeLabel);
            panel2.add(horseshoeChooser[i]);
            panel2.add(accessoryLabel);
            panel2.add(accessoryChooser[i]);

        frame2.add(panel2);
        }
       
        frame2.add(panel2);
        frame2.setVisible(true);
       
    }

    
    public static void main(String[] args) {
        new HorseCustom(3); // test with 3 horses
    }
}
