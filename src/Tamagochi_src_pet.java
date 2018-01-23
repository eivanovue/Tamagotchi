
class pet extends Command
{
    private Tamagotchi tamagotchi;

    public pet(Tamagotchi tamagotchi)
    {
        assert tamagotchi != null : "pet.pet gets null tamagotchi";
        this.tamagotchi = tamagotchi;
    }

    public String process(GameMain ui, Game game)
    {
        assert game != null : "feed.process gets null game";
        return game.pet(tamagotchi);
    }
}
