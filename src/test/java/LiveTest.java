
import org.junit.Assert;
import org.junit.Test;

import java.net.URL;

public class LiveTest {

    @Test
    public void liveTest() {
        int failcount = 0;
        try {
            final String urlString = "http://13.74.31.101/api/points";
            final URL url = new URL(urlString);
            final BowlingAPI bowlingAPI = BowlingAPI.getAPI(url);
            for(int i = 0; i <20; i++) {
                Game game = bowlingAPI.getGame();
                if (!(bowlingAPI.validateGame(game))) {
                    failcount ++;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
            failcount ++;
        }
        Assert.assertEquals(0, failcount);
    }
}
