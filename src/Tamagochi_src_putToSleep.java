
class putToSleep extends Command
{
    private Tamagotchi tamagotchi;

    public putToSleep(Tamagotchi tamagotchi)
    {
        assert tamagotchi != null : "putToSleep.putToSleep gets null tamagotchi";
        this.tamagotchi = tamagotchi;
    }

    public String process(GameMain ui, Game game) throws InterruptedException {
        assert game != null : "putToSleep.process gets null game";
        return game.putToSleep(tamagotchi);
    }
}
