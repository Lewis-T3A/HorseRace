import java.awt.*;
import javax.swing.*;
public class RaceGUI
{
    public static void main(String[] args) 
    {
        
        JFrame frame1= new JFrame("Horse Race Simulator");
        frame1.setSize(600,400);
        JPanel panel1 = new JPanel(new GridLayout(5,2,10,10));
        
        //Track length
        JLabel tracklength = new JLabel( "Track Length:" );
        JSpinner trackMod = new JSpinner(new SpinnerNumberModel(5,5,100,5));

        //Lane counts
        JLabel lanes = new JLabel ( "Lane Count;" );
        JSpinner laneMod = new JSpinner(new SpinnerNumberModel(2,2,10,1));
        // Track Shape
        JLabel shape = new JLabel( "Track Shape;" );
        JComboBox<String> shapeChooser = new JComboBox<>(new String[]{"Cirlce","Line","Square"});
        // Weather Condition
        JLabel Weather = new JLabel ( "Weather Condition:");
        JComboBox<String> WeatherChooser = new JComboBox<>(new String[]{"Dry","Wet","Windy","Hot"});
        //Start Button
        JButton start = new JButton ("Start");
        
        panel1.add(tracklength);
        panel1.add(trackMod);

        panel1.add(lanes);
        panel1.add(laneMod);

        panel1.add(shape);
        panel1.add(shapeChooser);

        panel1.add(Weather);
        panel1.add(WeatherChooser);

        panel1.add(new JLabel());
        panel1.add(start);
        
        frame1.add(panel1);
        frame1.setVisible(true);
    }
}
