import java.awt.*;
import javax.swing.*;
public class HorseCustom {
    //creating an array to store separate customised Horses.
    private Horse1[] Horse2;
    //constructor for Class HorseCustom.
    public HorseCustom(int laneCount)
    {

        //Instance of Horse1 created and put into the Horse2 Array.
        Horse2 = new Horse1[laneCount]; 

        // creating a new window called frame2, with the size of 1000px bu 600 px
        JDialog frame2 = new JDialog((Frame) null, "Horse Customisation", true);
        frame2.setSize(1000,600);

        //Creating a new panel called panel2 which will have all of the GUI items added to it.
        JPanel panel2 = new JPanel ();
        panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
       
        //Creating new Arrays that will hold inputs for each horse.
        JComboBox<String>[]breedChooser = new JComboBox[laneCount];
        JComboBox<String>[]colourChooser = new JComboBox[laneCount];
        JTextField[] symbolInput = new JTextField[laneCount];
        JComboBox<String>[]saddleChooser = new JComboBox[laneCount];
        JComboBox<String>[]horseshoeChooser = new JComboBox[laneCount];
        JComboBox<String>[]accessoryChooser = new JComboBox[laneCount];

        //loops to add each of the modifiers and choosers for each horse.
        for ( int i = 0; i<laneCount;i++)
        {
            // will create a panel for a single row of inputs - one row per new Horse
            JPanel panelrow = new JPanel(new GridLayout(2,6,10,10));

            // Adds the labels for each modifier and chooser.
            panelrow.add(new JLabel ("Breed:"));
            panelrow.add(new JLabel ("Colour:"));
            panelrow.add(new JLabel ("Symbol:"));
            panelrow.add(new JLabel ("Saddle type:"));
            panelrow.add(new JLabel ("Horseshoe type:"));
            panelrow.add(new JLabel ("Accessory:"));
            
            //Declaring the inputs that can be chosen from the combobox for breed of the Horses.
            
            breedChooser[i] = new JComboBox<>(new String[]{"Arabian","Thoroughbred","Quarter Horse"});

            //Declaring all of the coat colour inputs thatr can be chosen by the user for each Horse to have.
            
            colourChooser[i] = new JComboBox<>( new String[]{"Brown", "White","Black","Red","Golden","Spotted"});
            
            //Allowing the user to have free reign over their symbol input.
            
            symbolInput[i] = new JTextField(1);
            
            //Equipment and Accessories
            
            //Declaration of the saddle inputs that a user can choose for their horse to have.
            
            saddleChooser[i] = new JComboBox<> (new String[]{"Black","White","Gold","Red","Blue"});

            //Declaring the Type of horseshoe that a horse can have, with allowing for user input.
            
            horseshoeChooser[i] = new JComboBox<>(new String[]{"Light","Heavy","Regular"});

            //Declaring the accessories that a user can choose for their horse to have / equip.

            
            accessoryChooser[i] = new JComboBox<>(new String[]{"none","Hat","Blanket","Birdle"});
           
            // Adding all of the Comboboxes/ input boxes to the panelrow, which will then be added to the main panel.
            panelrow.add(breedChooser[i]);
            panelrow.add(colourChooser[i]);
            panelrow.add(symbolInput[i]);
            panelrow.add(saddleChooser[i]);
            panelrow.add(horseshoeChooser[i]);
            panelrow.add(accessoryChooser[i]);
  
            // adding each seperate row to the main panel.
        panel2.add(panelrow);
        }

        // creating a confirmation button which will collect inputs later on.
        JButton Confirm = new JButton ("Confirm Changes");
        panel2.add(new JLabel(""));

        // adding the button to the main panel.
        panel2.add(Confirm);

        // this adds the main panel to the frame/ window.
        frame2.add(panel2);
       
        // creating a new action listener for the confirm button
        Confirm.addActionListener(newEvent -> {
            // going through all Horses added and getting the values inputted for each combobox/ input box.
            for(int i =0; i<laneCount; i++)
            {
                String breed = (String) breedChooser[i].getSelectedItem();
                String colour = (String) colourChooser[i].getSelectedItem();
                String symbolText = symbolInput[i].getText();
                char symbol = symbolText.isEmpty() ? (char) ('A' + i) : symbolText.charAt(0);
                String saddle = (String) saddleChooser[i].getSelectedItem();
                String horseshoe = (String) horseshoeChooser[i].getSelectedItem();
                String accessory = (String) accessoryChooser[i].getSelectedItem();


                // new instance of Horse, adding all the inputs into it.
                Horse2[i] = new Horse1(symbol, "Horse " + (i + 1), 0.4, breed, colour, saddle, horseshoe, accessory);
                
            }
           frame2.dispose();
            
            
        });
        frame2.setVisible(true);
        
    }
    // returning the array.
    public Horse1[] getHorses()
    {
        return Horse2;
    }

}
