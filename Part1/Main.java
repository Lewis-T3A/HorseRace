public class Main {
    public static void main(String[] args) 
    {
        Horse horse1 = new Horse('A', "Jacob",0.6);
        Horse horse2 = new Horse('B', "Carlos" ,0.6);
        Horse horse3 = new Horse('C', "Melon",0.6);

        Race myRace = new Race(5);
        
        myRace.addHorse(horse1, 1);
        myRace.addHorse(horse2, 2);
        myRace.addHorse(horse3, 3);
        myRace.startRace();

        Race myRace2 = new Race(5);

        myRace2.addHorse(horse1,1);
        myRace2.addHorse(horse2,2);
        myRace2.addHorse(horse3,3);
        myRace2.startRace();
    }
}

// This is my main class which is used to create Horse instances and then race instanced and run the race by calling startRace()