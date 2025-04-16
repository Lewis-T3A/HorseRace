
/**
 * Write a description of class Horse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Horse1
{
    //Fields of class Horse
    private String name;
    private char symbol;
    private int distanceTravelled;
    private boolean fallen;
    private double confidence;
    private String breed;
    private String coatColour;
    private String saddle;
    private String horseshoe;
    private String accessory;
    
      
    //Constructor of class Horse
    /**
     * Constructor for objects of class Horse
     */
    public Horse1(char horseSymbol, String horseName, double horseConfidence, String breed, String coatColour, String saddle, String horseshoe, String accessory)
    {
       this.name = horseName;
       this.symbol = horseSymbol;
       this.distanceTravelled = 0;
       this.fallen = false;
       this.confidence = horseConfidence;
       this.breed = breed;
       this.coatColour = coatColour;
       this.saddle = saddle;
       this.horseshoe = horseshoe;
       this.accessory = accessory;
       customisationSet();
    }
    private void customisationSet()
    {
        if(getBreed().equals("Thoroughbred"))
        {
            setConfidence(this.confidence += 0.05);
        }
        else if (getBreed().equals("Arabian"))
        {
            setConfidence(this.confidence += 0.02);
        }
        else if (getBreed().equals("Quarter Horse"))
        {
            setConfidence(this.confidence += 0.03);
        }

        if(getHorseshoe().equals("Light"))
        {
            setConfidence(this.confidence += 0.02);
        }
        else if(getHorseshoe().equals("Heavy"))
        {
            setConfidence(this.confidence -= 0.02);
        }
    }

    public String getBreed()
    {
        return this.breed;
    }
    public String getCoatColour()
    {
        return this.coatColour;
    }
    public String getSaddle()
    {
        return this.saddle;
    }
    public String getHorseshoe()
    {
        return this.horseshoe;
    }
    public String getAccessory()
    {
        return this.accessory;
    }

    public void setBreed(String breed)
    {
        this.breed = breed;
    }
    public void getCoatColour(String coatColour)
    {
        this.coatColour = coatColour;
    }
    public void getSaddle(String saddle)
    {
        this.saddle = saddle;
    }
    public void getHorseshoe(String horseshoe)
    {
        this.horseshoe = horseshoe;
    }
    public void getAccessory(String accessory)
    {
        this.accessory = accessory;
    }

    
    
    
    //Other methods of class Horse
    public void fall()
    {
        this.fallen = true;
        setConfidence(this.confidence - 0.05);
    }
    
    public double getConfidence()
    {
        return this.confidence;
    }
    
    public int getDistanceTravelled()
    {
        return this.distanceTravelled;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public char getSymbol()
    {
        return this.symbol;
    }
    
    public void goBackToStart()
    {
        this.distanceTravelled = 0;
        this.fallen = false;
    }
    
    public boolean hasFallen()
    {
        return this.fallen;
    }

    public void moveForward()
    {
        this.distanceTravelled += 1;
    }

    public void setConfidence(double newConfidence)
    {
        if(newConfidence <0)
        {
            this.confidence = 0;
        }
        else if ( newConfidence >1)
        {
            this.confidence =1;
        }
        else
        {
            this.confidence = newConfidence;
        }
    }
    
    public void setSymbol(char newSymbol)
    {
        this.symbol = newSymbol;
    }
    
}

