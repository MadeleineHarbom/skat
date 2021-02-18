
import com.google.gson.Gson;


public class Game {

    private String token;
    private int[][] points;

    public int[] getPoints() {
        int size = this.points.length;
        size = size > 10 ? 10 : size;
        int[] summedArray = new int[size];

        for (int i = 0; i < size; i++) {
            int[] s = this.points[i];
            if(s[0] == 10) {
                summedArray[i] = sumStrike(i);
            } else if (s[0]+s[1] == 10) {
                summedArray[i] = sumSpare(i);

            }
            else {
                summedArray[i] = this.points[i][0] + this.points[i][1];
            }
        }
        int[] totalScore = new int[size];
        totalScore[0] = summedArray[0];
        for(int j = 1; j<size; j++) {
            totalScore[j] = totalScore[j-1] + summedArray[j];
        }
        return totalScore;
    }

    private int sumStrike(int i) {
        if(i < this.points.length-1) {
            if(this.points[i+1][0] == 10) {
                if (i < this.points.length-2) {
                    return 20 + this.points[i+2][0];
                } else {
                    return 20 + this.points[i+1][1];
                }
            } else {
                return 10 + this.points[i+1][0] + this.points[i+1][1];
            }
        } else {
            return 10;
        }
    }

    private int sumSpare(int i) {
        if(i < this.points.length-1) {
            return 10 + this.points[i+1][0];
        } else {
            return 10;
        }
    }

    public String asJson() {
        Gson gson = new Gson();
        int[] points = this.getPoints();
        return "{\"points\":" + gson.toJson(points) + ", \"token\": \"" + this.token + "\"}";
    }
}
