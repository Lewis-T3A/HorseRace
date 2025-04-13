import java.awt.*;
import javax.swing.*;
public class HorseCustom {
    public HorseCustom(int laneCount)
    {
        JFrame frame2 = new JFrame ( "Horse Customisation");
        frame2.setSize(600,400);
        JPanel panel2 = new JPanel (new GridLayout(5,2,10,10));
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComboBox<String>[]breedChooser = new JComboBox[laneCount];
        JComboBox<String>[]colourChooser = new JComboBox[laneCount];
        JTextField[] symbolInput = new JTextField[laneCount];
        JComboBox<String>[]saddleChooser = new JComboBox[laneCount];
        JComboBox<String>[]horseshoeChooser = new JComboBox[laneCount];
        JComboBox<String>[]accessoryChooser = new JComboBox[laneCount];


        //Horse Breed
        JLabel horseBreed = new JLabel("Horse Breed");
        JComboBox<String> breedChooser = new JComboBox<>(new String[]{"Arabian","Thoroughbred","Quarter Horse"});

        //Coat Colour
        JLabel horseColour = new JLabel ( "Coat Colour");
        JComboBox<String> colourChooser = new JComboBox<>( new String[]{"Brown", "White","Black","Red","Golden","Spotted"});
        
        //Symbol label and input
        JLabel horseSymbol = new JLabel ( "Horse Symbol ");
        JTextField symbolInput = new JTextField(1);
        
        //Equipment and Accessories
        
        //Saddle colour
        JLabel saddleColour = new JLabel("Saddle:");
        JComboBox<String> saddleChooser = new JComboBox<> (new String[]{"Black","White","Gold","Red","Blue"});

        //HorseShoe type
        JLabel horseShoeLabel = new JLabel ("HorseShoes:");
        JComboBox<String> horseShoeChooser = new JComboBox<>(new String[]{"Light","Heavy","Regular"});

        //Accessory

        JLabel accessoryLabel = new JLabel("Accessory:");
        JComboBox<String> accessoryChooser = new JComboBox<>(new String[]{"none","Hat","Blanket","Birdle"});
    }

    

}
