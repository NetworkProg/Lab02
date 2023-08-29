import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

public class WebClient {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java WebClient <url>");
            return;
        }

        String urlString = args[0];

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
