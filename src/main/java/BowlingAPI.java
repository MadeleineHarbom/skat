
import com.google.gson.Gson;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BowlingAPI {
    private final URL url;
    private BowlingAPI(URL url) {
        this.url = url;
    }

    public static BowlingAPI getAPI(URL url) {
        return new BowlingAPI(url);
    }

    public boolean validateGame(Game game) {
        HttpURLConnection con;
        try {
             con = getPostConnection(this.url);
            OutputStream os = con.getOutputStream();

            byte[] input = game.asJson().getBytes("utf-8");
            os.write(input, 0, input.length);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
            if (con.getResponseCode() != 200) {
                return false;
            }
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }

            Gson gson = new Gson();
            Result result = gson.fromJson(response.toString(), Result.class);
            return result.success;



        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; //TODO FX ME
    }

    public HttpURLConnection getPostConnection(URL url) throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        return con;
    }

    public Game getGame() {
        try {
            InputStream inputStream = url.openStream();

            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            String jsonText = sb.toString();


            Gson gson = new Gson();
            Game game = gson.fromJson(jsonText, Game.class);
            return game;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private class Result {
        boolean success;
        int[] input;
    }
}
