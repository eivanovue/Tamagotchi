/**
 * Created by user on 04/10/2017.
 */
import java.util.Scanner;


/**
 * This class is part of the "World of Home" application.
 * "World of Home" is a very simple, text based travel game.
 *
 * This parser reads user input and tries to interpret it as a
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a two-word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 *
 * @author  Michael Kölling, David J. Barnes and Olaf Chitil
 * @version 25/1/2017
 */
class Parser
{
    private Scanner reader;         // source of command input
    //private HashMap<String,Direction> directions;
    //private HashMap<String,Item> items;

    /**
     * Create a parser to read from the terminal window.
     */
    public Parser()
    {
        reader = new Scanner(System.in);

    }

    /**
     * @return The next command from the user.
     */
    public Command getCommand()
    {
        String inputLine;   // will hold the full input line
        String word = null;
        Game gam = new Game();
        System.out.print("\n> ");     // print prompt

        inputLine = reader.nextLine();
        String secondWord = null;
        // Find up to two words on the line.
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word = tokenizer.next();      // get first word
            if(tokenizer.hasNext()) {
                 secondWord = tokenizer.next();
            }
            switch (word) {
                case "feed" :
                   if (secondWord.equals(Game.getTamagotchi().getName())) {

                       return new feed(Game.getTamagotchi());
                   }
                    break;
                case "puttosleep" :
                    if (secondWord.equals(Game.getTamagotchi().getName())) {

                        return new putToSleep(Game.getTamagotchi());
                    }
                    break;
                 case "help" : return new help();
                case "givewater" :
                    if (secondWord.equals(Game.getTamagotchi().getName())) {
                        return new giveWater(Game.getTamagotchi());
                    }
                    break;
                case "pet" :
                    if (secondWord.equals(Game.getTamagotchi().getName())) {
                        return new pet(Game.getTamagotchi());
                    }
                    break;

                case "quit" : return new quit();
                case "forwardtime" : return new forwardtime();
            }

            // note: we just ignore the rest of the input line.
        }

        return new Command(); // unknown command
    }

    /**
     * Returns name of help command.
     */
    public String help()
    {
        return "help";
    }
}

