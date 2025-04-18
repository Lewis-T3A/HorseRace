import java.awt.*;
import javax.swing.*;
public class RaceGUI
{
    public static void main(String[] args) 
    {
        
        JFrame frame1= new JFrame("Horse Race Simulator");
        frame1.setSize(600,400);
        JPanel panel1 = new JPanel(new GridLayout(5,2,10,10));
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFrame raceScreen = new JFrame ( "Race Output");
        JTextArea raceOutput = new JTextArea();
        raceOutput.setFont(new Font("Monospaced",Font.PLAIN,14));
        raceScreen.add(new JScrollPane(raceOutput));
        raceScreen.setSize(1000,600);
        raceScreen.setVisible(true);

        //Track length 
        
        JLabel tracklength = new JLabel( "Track Length:" );
        JSpinner trackMod = new JSpinner(new SpinnerNumberModel(5,5,100,5));

        //Lane counts

        JLabel lanes = new JLabel ( "Lane Count;" );
        JSpinner laneMod = new JSpinner(new SpinnerNumberModel(2,2,10,1));

        // Track Shape

        JLabel shape = new JLabel( "Track Shape;" );
        JComboBox<String> shapeChooser = new JComboBox<>(new String[]{"Figure-Eight","Zigzag","Oval","Line"});

        // Weather Condition

        JLabel Weather = new JLabel ( "Weather Condition:");
        JComboBox<String> WeatherChooser = new JComboBox<>(new String[]{"Dry","Muddy","Icy"});

        //Start Button

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
        start.addActionListener(e -> {
            int trackLength = (Integer) trackMod.getValue();
            int laneCount = (Integer) laneMod.getValue();
            String trackShape = (String) shapeChooser.getSelectedItem();
            String raceWeather = (String) WeatherChooser.getSelectedItem();

            JOptionPane.showMessageDialog(frame1,"Track Length" + trackLength +"\n Lane Count" + laneCount + "\n Track Shape" + trackShape + "\n Weather Condition" + raceWeather );
            
            new HorseCustom(laneCount, horse2 -> {
                Race1 Race = new Race1 (trackLength, trackShape, raceWeather, laneCount);

                for(int i = 0; i < laneCount; i++)
                {
                    Race.addHorse(horse2[i], i + 1);
                }
                Race.startRace();
                
            });

            

        });
    }
}
