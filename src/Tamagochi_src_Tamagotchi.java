import java.util.Random;

/**
 * Created by eivanov on 1.10.2017 г..
 */
class Tamagotchi {
    private final String name;
    private String isHappy;
    private String isHungry;
    private String isThirsty;
    private String isSleepy;

    public Tamagotchi(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public String getIsHappy() { return isHappy;}
    public String getIsHungry() {
        return isHungry;
    }
    public String getIsSleepy() { return isSleepy;}
    public String getIsThirsty() {
        return isThirsty;
    }


    public void setIsHappy(String happy) { isHappy = happy;}
    public void setHungry(String hungry) {
        isHungry = hungry;
    }
    public void setThirsty(String thirsty) {
        isThirsty = thirsty;
    }
    public void setSleepy(String sleepy) {
        isSleepy = sleepy;
    }


    }

