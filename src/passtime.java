/**
 * Created by user on 05/10/2017.
 */
class forwardtime extends Command
{
    /**
     * Return help information.
     * Pre-condition: both ui and game are not null;
     */
    public String process(GameMain ui, Game game)
    {
        assert ui != null : "quit.process gets null ui";
        assert game != null : "quit.process gets null game";
        return game.forwardtime();
    }
}
