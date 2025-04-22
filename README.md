Horse Race Simulator Part 1:

  The Part 1 folder of My Horse race contains code to run a terminal/ text based running of the Horse race. 
  The Simulation starts with a base of 3 Horses with values that are customisable via the Main.java class, allowing the user to change the name, confidence, and symbol of the Horse.
  Horses under certain met conditions will:
    - Move forward using confidence as a base
    - Fall in the race, decided on a random integer, which impacts the performance of the Horse in the next race.
  Horses will win the Race, displaying so if they reach the end first.

  How To run Part 1:
    To run the textual version of the Horse race, the user would have to download the files first of all, then go into the part1 foilder, with specificity to Main.java.
    Within Main.java, there is 3 Horses initialised along with two seperate raced initialised, following one after another.
    If the User wants to only do one race, then they should comment out the second instance of the Race class, signified by new Race.
    To run this, the user would simply have to run the Main class/ main method in the Main.java class in their IDE or use the command java Main to run it in a normal terminal.
    The main Class would then run a method that will call the startRace() method in the Race class, which officially starts a race.

  Upon running:
    - Upon running the race, the user will see their declared horses move along the track until one reaches the end.
    - If a Horse falls, the symbol will change to X.
    - If a Horse wins, the winner name is displayed in a message below the actual race.
    - Horses statistics are displayed along the right of the race, displaying the name and confidence of said Horse.



Horse Race Simulator Part 2:

  The Part 2 folder of My Horse Race contains the start of some code for the build of a Gui for the Horse race. 
  In this version of the Horse race, multiple things are added for the user, including:
    - Added Horse Customisation panel which includes:
        - Horse Shoes
        - Horse accessories
        - Horse breed
        - Horse Saddle
        - Horse Coat Colour
      - Added Race Customisation GUI panel which includes:
        - Track length choosing
        - Amount of lanes
        - shape of the track ( effecting confidence)
        - Weather on the day of the race ( effecting confidence also ) .
      - Buttons for both Horse Customisation adn RaceCustomisation to set the Values.

    How to run Part2:
      - To run the GUi version of the Horse race, the user would have to open the files in the Part two folder, and run the RaceGUI class, which contains code to start the race.
      - Upon Running, the user will be displayed a screen of Race inputs.
      - After pressing start, the GUI window for changing Horse values, and upon confirming those values, the Race will run with the updated values of the Horse Race.
      - start the simulation with java RaceGUI
    
    Requirements:

    Java JDK 8+
    An IDE of some type.
      
