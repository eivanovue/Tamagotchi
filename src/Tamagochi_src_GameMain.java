import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by user on 04/10/2017.
 */
class GameMain {
    private Game game;
    //private Game game;
    private Parser parser;


    /**
     * Initialise.
     */
    public GameMain() throws IOException {
        game = new Game();
        game.createTamagotchi();
        parser = new Parser();
    }
    public void play() throws InterruptedException {
        System.out.println(game.welcome());


        while (!game.finished()) {
            Command command = parser.getCommand();
            System.out.println(command.process(this, game));
        }
    }
    public static void main(String[] args) throws IOException, InterruptedException {

        GameMain gameMain = new GameMain();
        gameMain.play();
    }
}
