import java.io.IOException;
import java.net.URL;

public class Runner {

    public static void main(String[] args)  {
        try {
            final String urlString = args[0];
            final URL url = new URL(urlString);
            final BowlingAPI bowlingAPI = BowlingAPI.getAPI(url);

            Game game = bowlingAPI.getGame();
            System.out.println(bowlingAPI.validateGame(game));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
