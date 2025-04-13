public class Main {
    public static void main(String[] args) 
    {
        Horse1 horse1 = new Horse1('A', "Jacob",0.6);
        Horse1 horse2 = new Horse1('B', "Carlos" ,0.6);
        Horse1 horse3 = new Horse1('C', "Melon",0.6);

        Race1 myRace = new Race1(5);
        
        myRace.addHorse(horse1, 1);
        myRace.addHorse(horse2, 2);
        myRace.addHorse(horse3, 3);
        myRace.startRace();

        Race1 myRace2 = new Race1(5);

        myRace2.addHorse(horse1,1);
        myRace2.addHorse(horse2,2);
        myRace2.addHorse(horse3,3);
        myRace2.startRace();
    }
}