import java.awt.*;
import javax.swing.*;
public class HorseCustom {
    public HorseCustom(int laneCount)
    {
        JFrame frame2 = new JFrame ( "Horse Customisation");
        frame2.setSize(1000,600);
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
            panelrow.add(new JLabel ("Colour:"));
            panelrow.add(new JLabel ("Symbol:"));
            panelrow.add(new JLabel ("Saddle type:"));
            panelrow.add(new JLabel ("Horseshoe type:"));
            panelrow.add(new JLabel ("Accessory:"));
            
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
           
            panelrow.add(breedChooser[i]);
            panelrow.add(colourChooser[i]);
            panelrow.add(symbolInput[i]);
            panelrow.add(saddleChooser[i]);
            panelrow.add(horseshoeChooser[i]);
            panelrow.add(accessoryChooser[i]);
  

        panel2.add(panelrow);
        }
        JButton Confirm = new JButton ("Confirm Changes");
        panel2.add(new JLabel(""));
        panel2.add(Confirm);
        frame2.add(panel2);
        frame2.setVisible(true);
        
        Confirm.addActionListener(e -> {
            Horse1[] horse2 = new Horse1[laneCount];
            for(int i =0; i<laneCount; i++)
            {
                String breed = (String) breedChooser[i].getSelectedItem();
                String colour = (String) colourChooser[i].getSelectedItem();
                String symbolText = symbolInput[i].getText();
                char symbol = symbolText.isEmpty() ? (char) ('A' + i) : symbolText.charAt(0);
                String saddle = (String) saddleChooser[i].getSelectedItem();
                String horseshoe = (String) horseshoeChooser[i].getSelectedItem();
                String accessory = (String) accessoryChooser[i].getSelectedItem();

                Horse1 horse = new Horse1(symbol,"Horse " + (i+1),0.4,breed,colour,saddle,horseshoe,accessory);

            }
            

        });
    }
    


    
    public static void main(String[] args) {
        new HorseCustom(4); // test with 3 horses
    }
}
