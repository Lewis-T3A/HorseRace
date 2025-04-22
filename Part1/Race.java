import java.util.concurrent.TimeUnit;

/**
 * A three-horse race, each horse running in its own lane
 * for a given distance
 * 
 * @author Lewis John Millin
 * @version 8.0
 */
public class Race
{
    private int raceLength;
    private Horse lane1Horse;
    private Horse lane2Horse;
    private Horse lane3Horse;

    
    public Race(int distance)
    {
        //Checks that the distance of the race is not less than 0, and if so then an exception would have to be thrown up
        if (distance <= 0)
        {
            throw new IllegalArgumentException("Cannot Have Negative Race Length");
        }
        // initialising the Horse lane variables
        raceLength = distance;
        lane1Horse = null;
        lane2Horse = null;
        lane3Horse = null;
    }
    
    // adds the Different horses to their separate lanes through an if statement.
    public void addHorse(Horse theHorse, int laneNumber)
    {
        if (laneNumber == 1)
        {
            lane1Horse = theHorse;
        }
        else if (laneNumber == 2)
        {
            lane2Horse = theHorse;
        }
        else if (laneNumber == 3)
        {
            lane3Horse = theHorse;
        }
        else
        {
            System.out.println("Cannot add horse to lane " + laneNumber + " because there is no such lane");
        }
    }
    
    
    public void startRace()
    {
        //declare a local variable to tell us when the race is finished
        boolean finished = false;
        
        //First checks that the horse in a lane is not null, and if so, it will send it back to the beginning, resetting its distance and fallen status.
        if ( lane1Horse != null)
        {
            lane1Horse.goBackToStart(); 
        }
        if ( lane2Horse != null)
        {
            lane2Horse.goBackToStart();
        }
        
        if ( lane3Horse != null)
        {
            lane3Horse.goBackToStart();
        }
        
                      
        while (!finished)
        {
            //move each horse
            moveHorse(lane1Horse);
            moveHorse(lane2Horse);
            moveHorse(lane3Horse);
                        
            //print the race positions
            printRace();
            
            //checks if any horse has reached the end of the track, and if they have it will be changed to the raceWinner variable which will then print the winner.
            Horse raceWinner = null;
            if(raceWonBy(lane1Horse))
            {
                raceWinner = lane1Horse;
            }
            else if (raceWonBy(lane2Horse))
            {
                raceWinner = lane2Horse;
            }
            else if (raceWonBy(lane3Horse))
            {
                raceWinner = lane3Horse;
            }
            // prints the winner as soon as raceWinner is declared as not null/ a horse replaces null, increasing confidence for the next race.
            if ( raceWinner !=null)
            {
                finished = true;
                System.out.println("The winner of this race is: " + raceWinner.getName());
                raceWinner.setConfidence(raceWinner.getConfidence()+ 0.05);
            }
            // checks all the horses status of fallen, and if all are true, then the race ends.
            if( lane1Horse.hasFallen() && lane2Horse.hasFallen() && lane3Horse.hasFallen())
            {
                System.out.println("All horses have fallen, no one wins");
                break;
            }
            //wait for 100 milliseconds
            try{ 
                TimeUnit.MILLISECONDS.sleep(100);
            }catch(Exception e)
            {

            }
        }
    }
    
    
    private void moveHorse(Horse theHorse)
    {
        //if the horse has fallen it will not move, and the if not, the higher thr confidence the more likely the horse is to move.
        
        if(theHorse == null) 
        {
            return;
        }
        if  (!theHorse.hasFallen())
        {
            //the probability that the horse will move forward depends on the confidence;
            if (Math.random() < theHorse.getConfidence())
            {
               theHorse.moveForward();
            }
            
            //the probability that the horse will fall is very small (max is 0.1)
            //but will also will depends exponentially on confidence 
            //so if you double the confidence, the probability that it will fall is *2
            if (Math.random() < (0.1*theHorse.getConfidence()*theHorse.getConfidence()))
            {
                theHorse.fall();
            }
        }
    }
    // checks which horse won the race by first checking that the horse is not null and has not fallen, and if so , by reaching the end, they are declared as winner.
    private boolean raceWonBy(Horse theHorse)
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
    
    // prints the race track as text onto the field.
    private void printRace()
    {
        System.out.print('\u000C');  //clear the terminal window
        
        multiplePrint('=',raceLength+3); //top edge of track
        System.out.println();
        
        printLane(lane1Horse);
        System.out.println();
        
        printLane(lane2Horse);
        System.out.println();
        
        printLane(lane3Horse);
        System.out.println();
        
        multiplePrint('=',raceLength+3); //bottom edge of track
        System.out.println();    
    }
    
   // prints the Horse into their respective lane
    private void printLane(Horse theHorse)
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
        
    
    // prints multiple characters
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
