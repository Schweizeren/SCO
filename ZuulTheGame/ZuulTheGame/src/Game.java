/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room mainhall, wc, kitchen, hallway, smallbedroom, masterbedroom, WC, diningroom, basement, cell, dungeonhallway, room1, room2, room3, room4,  room5,  room6,  room7,  room8,  room9, room10, room11, room12, room13;
      
        // create the rooms
        mainhall = new Room("The Main Hall");
        wc = new Room("The Small Toilet");
        kitchen = new Room("The Kitchen");
        hallway = new Room("The Hallway to the sleeping quarters");
        smallbedroom = new Room("The Small Bedroom");
        masterbedroom = new Room("masterbedroom");
        WC = new Room("The Big Toilet");
        diningroom = new Room("The Dining Room");
        basement = new Room("The Basement");
        cell = new Room("The Prison Cell");
        dungeonhallway = new Room("A hallway to something sinister");
        room1 = new Room("a Sinister Room");
        room2 = new Room("a Sinister Room");
        room3 = new Room("a Sinister Room");
        room4 = new Room("a Sinister Room");
        room5 = new Room("a Sinister Room");
        room6 = new Room("a Sinister Room");
        room7 = new Room("a Sinister Room");
        room8 = new Room("a Sinister Room");
        room9 = new Room("a Sinister Room");
        room10 = new Room("a Sinister Room");
        room11 = new Room("a Sinister Room");
        room12 = new Room("a Sinister Room");
        room13 = new Room("an angelic Room");
        
        
        
        // initialise room exits
        // (Room north, Room east, Room south, Room west)
        
        mainhall.setExits(wc,kitchen,null,hallway);
        wc.setExits(null,null,mainhall,null);
        hallway.setExits(smallbedroom,mainhall,null,null); // Lav fobindelse til basement
        smallbedroom.setExits(masterbedroom,WC,hallway,null);
        masterbedroom.setExits(null,null,smallbedroom,null);
        WC.setExits(null,null,null,smallbedroom);
        kitchen.setExits(diningroom,null,null,mainhall);
        diningroom.setExits(null,null,kitchen,null);
        basement.setExits(null,cell,null,null); // Lav fobindelse til hallway
        cell.setExits(null,dungeonhallway,null,basement);
        dungeonhallway.setExits(room2,room1,null,cell);
        room1.setExits(room3,null,null,dungeonhallway);
        room2.setExits(room4,room3,dungeonhallway,null);
        room3.setExits(null,null,room1,room2);
        room4.setExits(room5,room6,room2,null);
        room5.setExits(null,null,room4,null);
        room6.setExits(null,room7,null,room4);
        room7.setExits(room8,null,room9,room6);
        room8.setExits(null,null,room7,null);
        room9.setExits(room7,null,room10,null);
        room10.setExits(room9,room11,null,null);
        room11.setExits(room12,null,null,room10);
        room12.setExits(room13,null,room11,null);
        room13.setExits(null,null,room12,null);
        
        currentRoom = mainhall;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("You are " + currentRoom.getDescription());
        System.out.print("Exits: ");
        if(currentRoom.northExit != null) {
            System.out.print("north ");
        }
        if(currentRoom.eastExit != null) {
            System.out.print("east ");
        }
        if(currentRoom.southExit != null) {
            System.out.print("south ");
        }
        if(currentRoom.westExit != null) {
            System.out.print("west ");
        }
        System.out.println();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = null;
        if(direction.equals("north")) {
            nextRoom = currentRoom.northExit;
        }
        if(direction.equals("east")) {
            nextRoom = currentRoom.eastExit;
        }
        if(direction.equals("south")) {
            nextRoom = currentRoom.southExit;
        }
        if(direction.equals("west")) {
            nextRoom = currentRoom.westExit;
        }

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println("You are in " + currentRoom.getDescription());
            System.out.print("Exits: ");
            if(currentRoom.northExit != null) {
                System.out.print("north ");
            }
            if(currentRoom.eastExit != null) {
                System.out.print("east ");
            }
            if(currentRoom.southExit != null) {
                System.out.print("south ");
            }
            if(currentRoom.westExit != null) {
                System.out.print("west ");
            }
            System.out.println();
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
