/**
 * Created by eivanov on 1.10.2017 г..
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Game {
    //possible moods and levels
    private static Tamagotchi tamagotchi;
    private static String[] isHungry;
    private static String[] isThirsty;
    private static String[] isSleepy;
    private static String[] isHappy;


    //current moods and levels
    String currentHunger;
    String currentThirst;
    String currentPet;
    String currentTiredness;
    boolean finished;


 public Game() {
     finished = false;

 }

    protected void createTamagotchi() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Hello. Let's create your tamagotchi! Start by giving it a name: ");
        String name = br.readLine();
        Tamagotchi tam = new Tamagotchi(name);
        tamagotchi = tam;
        setTamagotchi(tam);
        System.out.println(name + ": has been created, now take care of it!");
    }

    public void update(){
     currentHunger = tamagotchi.getIsHungry();
     currentThirst = tamagotchi.getIsThirsty();
     currentPet = tamagotchi.getIsHappy();
     currentTiredness = tamagotchi.getIsSleepy();


         //Increment hunger
         for(int i = 0; i < isHungry.length; i++){

             if(isHungry[i].equals(currentHunger)){
                 tamagotchi.setHungry(isHungry[i+1]);
             }
         }
        //Increment thirst
        for(int i = 0; i < isThirsty.length; i++){

            if(isThirsty[i].equals(currentThirst)){
                tamagotchi.setThirsty(isThirsty[i+1]);
            }
        }
        //Increment pet
        for(int i = 0; i < isHappy.length; i++){

            if(isHappy[i].equals(currentPet)){
                tamagotchi.setIsHappy(isHappy[i+1]);
            }
        }
        //Increment tiredness
        for(int i = 0; i < isSleepy.length; i++){

            if(isSleepy[i].equals(currentTiredness)){
                tamagotchi.setSleepy(isSleepy[i+1]);
            }
        }


        currentHunger = tamagotchi.getIsHungry();
        currentThirst = tamagotchi.getIsThirsty();
        currentPet = tamagotchi.getIsHappy();
        currentTiredness = tamagotchi.getIsSleepy();



    }

    public void status(){

        currentHunger = tamagotchi.getIsHungry();
        currentThirst = tamagotchi.getIsThirsty();
        currentPet = tamagotchi.getIsHappy();
        currentTiredness = tamagotchi.getIsSleepy();


        System.out.println("==========Tamagotchi status==========");
        System.out.println(currentHunger);
        System.out.println(currentThirst);
        System.out.println(currentPet);
        System.out.println(currentTiredness);

    }


    public String forwardtime(){

        update();
        if(currentHunger.equals("dead") || currentThirst.equals("dead") || currentPet.equals("dead") || currentTiredness.equals("dead")){
            System.out.println("Your tamagochi has died. You should have taken care of it!");
            quit();
            System.exit(0);

        }
        status();

        return "Some time has passed...";
    }

    protected static Tamagotchi getTamagotchi() {
        return tamagotchi;
    }

    private  void setTamagotchi(Tamagotchi tam) {
        String name = tam.getName();
        //set moods and order them by satisfied to not satisfied tamagotchi
        isHungry = new String[]{name + ": is fed!", name + ": is getting hungry!", name + ": is very hungry!", name + ": is starving!", name + ": is about to die from hunger!", "dead"};
        tam.setHungry(isHungry[3]);
        isThirsty = new String[]{name + ": is not thirsty!", name + ": is getting thirsty!", name + ": is very thirsty!", name + ": is dying to drink water!", name + ": is about to die from thirst!","dead"};
        tam.setThirsty(isThirsty[2]);
        isSleepy = new String[]{name + ": is not sleepy!", name + ": is getting sleepy!", name + ": is very sleepy!", name + ": is dying to get some sleep!", name + ": is about to die from tiredness!","dead"};
        tam.setSleepy(isSleepy[4]);
        isHappy = new String[]{name + ": is very happy!", name + ": is smiling!", name + ": is in a bad mood!", name + ": is dying to be pet!", name + ": is sad!","dead"};
        tam.setIsHappy(isHappy[4]);

        currentHunger = tamagotchi.getIsHungry();
        currentThirst = tamagotchi.getIsThirsty();
        currentPet = tamagotchi.getIsHappy();
        currentTiredness = tamagotchi.getIsSleepy();
        status();
    }

    public String quit()
    {
        finished = true;
        return "Thank you for playing.  Good bye.";
    }

    public boolean finished()
    {
        return finished;
    }

    public String welcome(){

        return "";
    }

    public String help()
    {
        return "=========Available commands=========\n" +
                "\n" +
                "[EXAMPLE]        feed Tam" +
                " help, feed <name>, givewater <name>\n" +
                "puttosleep <name>, pet <name>\n" +
                "\n" +
                "======================================";
    }

    public String feed(Tamagotchi tam)
    {
        assert tam != null : "Game.feed tamagotchi is null";


            tam.setHungry(isHungry[0]);
            status();
            return "Food given to: " + tam.getName();


    }

    public String putToSleep(Tamagotchi tam) throws InterruptedException {
        assert tam != null : "Game.putToSleep tamagotchi is null";
        int sleepy = Arrays.asList(isSleepy).indexOf(tam.getIsSleepy());
        if (sleepy < isSleepy.length) {
            tam.setSleepy(isSleepy[0]);
           System.out.println("Putting " + tam.getName() + " to sleep for 10 seconds for the purpose of this showcase!");
           System.out.println(tam.getName() + " is sleeping..");
           Thread.sleep(10000);

            status();
        }
            return tam.getName() + " is awake!" ;

    }

    public String giveWater(Tamagotchi tam)
    {
        assert tam != null : "Game.giveWater tamagotchi is null";
        int thrist = Arrays.asList(isThirsty).indexOf(tam.getIsThirsty());
        if (thrist < isThirsty.length) {
            tam.setThirsty(isThirsty[0]);
            status();
            return "Water given to: " + tam.getName();
        } else {
            return "Not thirsty enough!";
        }
    }

    public String pet(Tamagotchi tam)
    {
        assert tam != null : "Game.giveWater tamagotchi is null";
        int happy = Arrays.asList(isHappy).indexOf(tam.getIsHappy());
        if (happy < isHappy.length) {
            tam.setIsHappy(isHappy[0]);
            status();
            return "petting: " + tam.getName();
        } else {
            return "is already happy!";
        }
    }

}



