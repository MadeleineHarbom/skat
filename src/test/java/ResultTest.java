
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class ResultTest {

    @Test
    public void TestTotalScore1() {
        int[][] scores= {
                {3,7},
                {10,0},
                {8,2},
                {8,1},
                {10,0},
                {3,4},
                {7,0},
                {5,5},
                {3,2},
                {2,5}};
        Gson gson = new Gson();
        String jsonText = "{\"points\":" + gson.toJson(scores) + ", \"token\": \"placeholder\"}";
        Game g = gson.fromJson(jsonText, Game.class);
        int[] totalscore = g.getPoints();
        Assert.assertArrayEquals(totalscore, new int[] {20, 40, 58, 67, 84, 91, 98, 111,116, 123});

    }

    @Test
    public void TestTotalScore2() {
        String token = "OCAFRMqItva32x061DzOs8rybZ5jBKDQ";
        int[][] scores= {
                {10,0},
                {10,0},
                {10,0},
                {10,0},
                {10,0},
                {10,0},
                {10,0},
                {10,0},
                {10,0},
                {10,0},
                {10,10}};
        Gson gson = new Gson();
        String jsonText = "{\"points\":" + gson.toJson(scores) + ", \"token\": \"" + token+ "\"}";
        Game g = gson.fromJson(jsonText, Game.class);
        int[] totalscore = g.getPoints();
        Assert.assertArrayEquals(new int[] {30, 60, 90, 120, 150, 180, 210, 240, 270, 300}, totalscore);
    }

    @Test
    public void TestTotalScore3() {
        String token = "WC9maMOVjYsuy26vDIsoBFszIHRfO6Xi";
        int[][] scores= {
                {2,8},
                {4,1},
                {9,1},
                {0,3},
                {4,2},
                {2,1},
                {6,3},
                {4,2},
                {6,4}};
        Gson gson = new Gson();
        String jsonText = "{\"points\":" + gson.toJson(scores) + ", \"token\": \"" + token+ "\"}";
        Game g = gson.fromJson(jsonText, Game.class);
        int[] totalscore = g.getPoints();
        Assert.assertArrayEquals(totalscore, new int[] {14, 19, 29, 32, 38, 41, 50, 56, 66});
    }

    @Test
    public void TestTotalScore4() {
        String token = "JciV4Ka1QertRlw7GjuhSJIZ8hkPSNm9";
        int[][] scores= {
                {7,3},
                {6,0},
                {9,1}};
        Gson gson = new Gson();
        String jsonText = "{\"points\":" + gson.toJson(scores) + ", \"token\": \"" + token+ "\"}";
        Game g = gson.fromJson(jsonText, Game.class);
        int[] totalscore = g.getPoints();
        Assert.assertArrayEquals(totalscore, new int[] {16, 22, 32});
    }

}
