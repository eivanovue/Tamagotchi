
class feed extends Command
{
    private Tamagotchi tamagotchi;

    /**
     * Initialise the direction.
     * Pre-condition: direction is not null.
     */
    public feed(Tamagotchi tamagotchi)
    {
        assert tamagotchi != null : "feed.feed gets null tamagotchi";
        this.tamagotchi = tamagotchi;
    }

    /**
     * feed in the given direction.
     * Pre-condition: game is not null.
     */
    public String process(GameMain ui, Game game)
    {
        assert game != null : "feed.process gets null game";
        return game.feed(tamagotchi);
    }
}
