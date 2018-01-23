class giveWater extends Command
{
    private Tamagotchi tamagotchi;


    public giveWater(Tamagotchi tamagotchi)
    {
        assert tamagotchi != null : "giveWater.giveWater gets null tamagotchi";
        this.tamagotchi = tamagotchi;
    }

    /**
     * feed in the given direction.
     * Pre-condition: game is not null.
     */
    public String process(GameMain ui, Game game)
    {
        assert game != null : "feed.process gets null game";
        return game.giveWater(tamagotchi);
    }
}