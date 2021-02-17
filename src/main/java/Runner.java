import java.net.URL;

public class Runner {

    public static void main(String[] args)  {
        try {
        final String urlString = args[0];
        final URL url = new URL(urlString);
        final BowlingAPI bowlingAPI = BowlingAPI.getAPI(url);
            for (int i = 0; i < 20; i++) {
                Game game = bowlingAPI.getGame();
                System.out.println(bowlingAPI.validateGame(game));
            }
        } catch (Exception e) {
            e.printStackTrace();
            //TODO CRASH EVERYTHING
        }



    }
}
