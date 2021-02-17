
import com.google.gson.Gson;


public class Game {

    private String token;
    private int[][] points;



    public int[] getPoints() {
        //TODO delete me
        System.out.println("Get points");
        Gson gson = new Gson();
        System.out.println(this.token);
        System.out.println(gson.toJson(this.points));
        int[] last =  this.points[this.points.length-1];
        int size;
        if (last[0] == 10 || last[1]== 10) {
            size = this.points.length-1;
        } else {
            size = this.points.length;
            size = size <= 10 ? size : 10;

        }
        int[] summedArray = new int[size];
        for (int i = 0; i < size; i++) {
            int[] s = this.points[i];
            if(s[0] == 10) {
                summedArray[i] = sumStrike(i);
            } else if (s[0]+s[1] == 10) {
                summedArray[i] = 10 + this.points[i+1][0];

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
        int strikeScore = 0;
        if(this.points[i+1][0] == 10) {
            try {
                strikeScore = 10 + this.points[i+1][0] +this.points[i+2][0];
            } catch (IndexOutOfBoundsException e) {
                strikeScore = 10 + this.points[i+1][0] + this.points[i+1][1];
            }
        } else {
            strikeScore = 10 + points[i+1][0] + points[i+1][1];
        }
        return strikeScore;
    }

    public String asJson() {
        Gson gson = new Gson();
        int[] points = this.getPoints();
        String jsonText = "{\"points\":" + gson.toJson(points) + ", \"token\": \"" + this.token + "\"}";
        return jsonText;
    }
}
