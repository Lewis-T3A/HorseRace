import java.awt.*;
import javax.swing.*;
public class HorseCustom {
    public static void main(String[] args)
    {
        JFrame frame2 = new JFrame ( "Horse Customisation");
        frame2.setSize(600,400);
        JPanel panel2 = new JPanel (new GridLayout(5,2,10,10));
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //Horse Breed
    JLabel horseBreed = new JLabel("Horse Breed");
    JComboBox<String> breedChooser = new JComboBox<>(new String[]{"Arabian","Thoroughbred","Quarter Horse"});

    //Coat Colour
    JLabel horseColour = new JLabel ( "Coat Colour");
    JComboBox<String> colourChooser = new JComboBox<>( new String[]{"Brown", "White","Black","Red","Golden","Spotted"});
    //Symbol 
    JLabel horseSymbol = new JLabel ( "Horse Symbol ");
    JTextField symbolInput = new JTextField(1);
    //Equipment and Accessories
    
}
