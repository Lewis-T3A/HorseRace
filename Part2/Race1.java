import java.util.concurrent.TimeUnit;

/**
 * A three-horse race, each horse running in its own lane
 * for a given distance
 * 
 * @author McRaceface
 * @version 1.0
 */
public class Race1
{
    
    private int raceLength;
    private String trackShape;
    private String raceWeather;
    private Horse1[] lane;
    

    /**
     * Constructor for objects of class Race
     * Initially there are no horses in the lanes
     * 
     * @param distance the length of the racetrack (in metres/yards...)
     */
    public Race1(int distance, String trackShape, String raceWeather, int laneCount)
    {
        // first checks that the inputtes distance is not less than 0.
        if (distance <= 0)
        {
            throw new IllegalArgumentException("Cannot Have Negative Race Length");
        }

        // initialise instance variables including the new Horses.
        this.trackShape = trackShape;
        this.raceWeather = raceWeather;
        raceLength = distance;
        this.lane = new Horse1[laneCount];
    }
    
    /**
     * Adds a horse to the race in a given lane
     * 
     * @param theHorse the horse to be added to the race
     * @param laneNumber the lane that the horse will be added to
     */
    public void addHorse(Horse1 theHorse, int laneNumber)
    {
        //adds Horses up to the amount of lanes created.
        if(laneNumber >= 1 && laneNumber <= lane.length)
        {
            lane[laneNumber-1] = theHorse;
        }
        else
        {
            System.out.println("Cannot add Horse to lane" + laneNumber + "Because there is no such lane");
        }
    }
    
    /**
     * Start the race
     * The horse are brought to the start and
     * then repeatedly moved forward until the 
     * race is finished
     */
    public void startRace()
    {
        //declare a local variable to tell us when the race is finished
        boolean finished = false;
        
        // resets the lane of a Horse if it is not null, going through the whole array and checking each instance of  a Horse created.
        for(Horse1 horse: lane)
        {
            if(horse != null)
            {
                horse.goBackToStart();
            }
        }
        
        // Apply one-time confidence modifiers based on track shape and weather
for (Horse1 horse : lane) {
    if (horse == null) continue;

    // Track shape adjustments
    if(trackShape.equals("Figure-Eight")) 
    {
        horse.setConfidence(horse.getConfidence() - 0.01);
    } 
    else if (trackShape.equals("Zigzag")) 
    {
        horse.setConfidence(horse.getConfidence() - 0.05);
    } 
    else if (trackShape.equals("Oval")) 
    {
        horse.setConfidence(horse.getConfidence() + 0.05);
    } 
    else if (trackShape.equals("Line")) 
    {
        horse.setConfidence(horse.getConfidence() + 0.01);
    }

    
    if(raceWeather.equals("Dry")) 
    {
        horse.setConfidence(horse.getConfidence() + 0.01);
    } 
    else if (raceWeather.equals("Muddy")) 
    {
        horse.setConfidence(horse.getConfidence() - 0.01);
    } 
    else if (raceWeather.equals("Icy")) 
    {
        horse.setConfidence(horse.getConfidence() - 0.05);
    }
}

         // Keeps the Horses moving until the race is finished.             
        while (!finished)
        {
            //moves each horse using the moveHorse method
            for(Horse1 horse: lane)
            {
                moveHorse(horse);
            }
                        
            //print the race positions
            printRace();
            
            //checks if any horse has reached the end, and if so, it will declare the raceWinner to be that Horse.
            Horse1 raceWinner = null;
            for(Horse1 horse:lane)
            {
                if(raceWonBy(horse))
                {
                    raceWinner = horse;
                    break;
                }
                
            }
            // ensuring that the racewinner cannot be a fallen horse or one that is not declared, and if not null, it will declare the rcae as finished.
            if ( raceWinner !=null)
            {
                finished = true;
                System.out.println("The winner of this race is: " + raceWinner.getName());
                raceWinner.setConfidence(raceWinner.getConfidence()+ 0.05);
            }
            // code for stopping the race if all horses are finished, ensuring that the race doesnt loop infinitely.
            // essentially checks that not all of the Horses have fallen, and if so, it will set allFall to false, but if not , it means all horses have fallsen so will meet the condition to stop the race.
            boolean allFall = true;
            for(Horse1 horse:lane)
            {
                if(horse != null && !horse.hasFallen())
                {
                    allFall = false;
                    break;
                }
            }
            if(allFall)
            {
                System.out.println("All Horses have fallen, no winner");
                break;
            }
            //wait for 100 milliseconds
            try{ 
                TimeUnit.MILLISECONDS.sleep(100);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Randomly make a horse move forward or fall depending
     * on its confidence rating
     * A fallen horse cannot move
     * 
     * @param theHorse the horse to be moved
     */
    private void moveHorse(Horse1 theHorse)
    {
        //if the horse has fallen it cannot move, 
        //so only run if it has not fallen
        if(theHorse == null  || theHorse.hasFallen()) 
        {
            return;
        }

        
        
            //the probability that the horse will move forward depends on the confidence;
        
        boolean movedAlready = false;
        if (Math.random() < theHorse.getConfidence())
        {
            theHorse.moveForward();
            movedAlready =true;
        }

        
            
        //the probability that the horse will fall is very small (max is 0.1)
        //but will also will depends exponentially on confidence 
        //so if you double the confidence, the probability that it will fall is *2
        if (movedAlready && Math.random() < (0.1*theHorse.getConfidence()*theHorse.getConfidence()))
        {
            theHorse.fall();
        }
        
    }
        
    /** 
     * Determines if a horse has won the race
     *
     * @param theHorse The horse we are testing
     * @return true if the horse has won, false otherwise.
     */
    private boolean raceWonBy(Horse1 theHorse)
    {
        if(theHorse != null && !theHorse.hasFallen())
        {
            if (theHorse.getDistanceTravelled() == raceLength)
            {
                return true;
            }
        }
        return false;
    }
    
    /***
     * Print the race on the terminal
     */
    private void printRace()
    {
        System.out.print('\u000C');  //clear the terminal window
        
        multiplePrint('=',raceLength+3); //top edge of track
        System.out.println();
        
        for(Horse1 horse: lane)
        {
            printLane(horse);
            System.out.println();
        }
        
        multiplePrint('=',raceLength+3); //bottom edge of track
        System.out.println();    
    }
    
    /**
     * print a horse's lane during the race
     * for example
     * |           X                      |
     * to show how far the horse has run
     */
    private void printLane(Horse1 theHorse)
    {
        if(theHorse == null)
        {
            System.out.print('|');
            multiplePrint(' ',raceLength);
            System.out.print('|');
            System.out.print("");
            return;
        }
        //calculate how many spaces are needed before
        //and after the horse
        int spacesBefore = theHorse.getDistanceTravelled();
        int spacesAfter = raceLength - theHorse.getDistanceTravelled();
        
        //print a | for the beginning of the lane
        System.out.print('|');
        
        //print the spaces before the horse
        multiplePrint(' ',spacesBefore);
        
        //if the horse has fallen then print dead
        //else print the horse's symbol
        if(theHorse.hasFallen())
        {
            System.out.print('X');
        }
        else
        {
            System.out.print(theHorse.getSymbol());
        }
        
        //print the spaces after the horse
        multiplePrint(' ',spacesAfter);
        
        //print the | for the end of the track
        System.out.print('|');

        System.out.printf(" Name: %s ( Confidence: %.2f )", theHorse.getName(),theHorse.getConfidence());
    }
        
    
    /***
     * print a character a given number of times.
     * e.g. printmany('x',5) will print: xxxxx
     * 
     * @param aChar the character to Print
     */
    private void multiplePrint(char aChar, int times)
    {
        int i = 0;
        while (i < times)
        {
            System.out.print(aChar);
            i = i + 1;
        }
    }
}

