import java.awt.*;
import javax.swing.*;
public class RaceGUI
{
    public static void main(String[] args) 
    {

         // Creating the main window for my GUI, setting its size to 600 px by 400 px
        JFrame frame1= new JFrame("Horse Race Simulator");
        frame1.setSize(600,400);

        // Creating a panel that has a grid layout for positioning that would hold my separate GUI components 
        JPanel panel1 = new JPanel(new GridLayout(5,2,10,10));

        // used to close the program upon closing the window.
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        

        //Track length label added along with a Jspinner, so the user can click incremental values to increase by
        
        JLabel tracklength = new JLabel( "Track Length:" );
        JSpinner trackMod = new JSpinner(new SpinnerNumberModel(5,5,100,5));

        //Lane counts label added along with a jspinner that allows the user to increase the amount of lanes incrementally up until a max of 10.

        JLabel lanes = new JLabel ( "Lane Count;" );
        JSpinner laneMod = new JSpinner(new SpinnerNumberModel(2,2,10,1));

        // Track shape label added along with a combo box for choosing from alist of the options

        JLabel shape = new JLabel( "Track Shape;" );
        JComboBox<String> shapeChooser = new JComboBox<>(new String[]{"Figure-Eight","Zigzag","Oval","Line"});

        // Weather Condition label added along with a combo box for choosing from a set amount of Weather types to take effect.

        JLabel Weather = new JLabel ( "Weather Condition:");
        JComboBox<String> WeatherChooser = new JComboBox<>(new String[]{"Dry","Muddy","Icy"});

        //Start Button added to the bottom which will later collect values.

        JButton start = new JButton ("Start");

        // adding the length of the track modifer for the user to change ontop the panel

        panel1.add(tracklength);
        panel1.add(trackMod);

        // adding the lane modifier for the user to the panel

        panel1.add(lanes);
        panel1.add(laneMod);

        // adding the Track shape modifier for the user to use to the panel

        panel1.add(shape);
        panel1.add(shapeChooser);

        // adding the Weather modifier for the user to choose to the panel

        panel1.add(Weather);
        panel1.add(WeatherChooser);

        //adding the start button to the panel

        panel1.add(new JLabel());
        panel1.add(start);

        // adding the panel to the frame, and setting the frame to visible.

        frame1.add(panel1);
        frame1.setVisible(true);

        // creating an action listener
        start.addActionListener(e -> 
        {
            // Used to get the inputed values from the user.
            int trackLength = (Integer) trackMod.getValue();
            int laneCount = (Integer) laneMod.getValue();
            String trackShape = (String) shapeChooser.getSelectedItem();
            String raceWeather = (String) WeatherChooser.getSelectedItem();

            // after inputting the values and clicking start, it will show a pop up window of what the user inputted.
            JOptionPane.showMessageDialog(frame1,"Track Length" + trackLength +"\n Lane Count" + laneCount + "\n Track Shape" + trackShape + "\n Weather Condition" + raceWeather );
            
            // used to get the Horse customisation window and get the Customised Horse values for each horse.
            HorseCustom customRace = new HorseCustom(laneCount);
            Horse1[] Horse2 = customRace.getHorses();

            // instance of the Race class created , and adds the Horses to it using a for loop.
            Race1 Race = new Race1(trackLength,trackShape,raceWeather,laneCount);


            for(int i = 0; i< Horse2.length; i++)
            {
                Race.addHorse(Horse2[i], i+1);
            }
            Race.startRace();

            

        });
    }
}
