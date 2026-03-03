import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MinimumSwapsToArrangeABinaryGrid {

    public int minSwaps(int[][] grid) {

        int n = grid.length;
        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) count++;
                else break;
            }
            map.put(i, count);
        }

        ArrayList<Integer> arr = new ArrayList<>(map.values());

        Collections.sort(arr, (a, b) -> b - a);

        for (int i = 0; i < n; i++) {
            if (arr.get(i) < (n - 1 - i)) {
                return -1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr.get(i) != map.get(i)) {
                ans++;
            }
        }

        return ans;
    }
}


class Solution6 {

    private static final String API_KEY = "my api key";
    private static final String api = "0e0fac0115ca4157b70faf01e30adb1f";
    private static final String URL =
            "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=" + API_KEY;

    public int calculate(String s) {
        try {

            String prompt = "Evaluate this mathematical expression and return only the integer result. "
                    + "Integer division should truncate toward zero. Expression: " + s;

            String jsonBody = "{"
                    + "\"contents\": [{"
                    + "\"parts\": [{\"text\": \"" + prompt.replace("\"", "\\\"") + "\"}]"
                    + "}]"
                    + "}";

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            String body = response.body();

            int textKeyIndex = body.indexOf("\"text\":");
            if (textKeyIndex == -1) return 0;

            int firstQuote = body.indexOf("\"", textKeyIndex + 7);
            int secondQuote = body.indexOf("\"", firstQuote + 1);

            if (firstQuote == -1 || secondQuote == -1) return 0;

            String modelOutput = body.substring(firstQuote + 1, secondQuote).trim();

            modelOutput = modelOutput.replaceAll("\\s+", "");

            return Integer.parseInt(modelOutput);

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public static void main(String[] args) {
        Solution6 sol = new Solution6();
//        System.out.println(sol.calculate("3+2*2"));
//        System.out.println(sol.calculate(" 3/2 "));
//        System.out.println(sol.calculate(" 3+5 / 2 "));

        System.out.println(sol.show("india"));
        System.out.println(sol.getTopHeadlines("india"));
    }

    public String getTopHeadlines(String country) {
        try {


            String jsonBody = "{"
                    + "\"country\": \"" + country + "\","
                    + "\"apiKey\": \"" + api + "\""
                    + "}";

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://newsapi.org/v2/everything"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            String body = response.body();


            return body;

        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred";
        }
    }

    public int show(String s) {
        try {

            String jsonBody = "{"
                    + "\"country\": \"" + s + "\","
                    + "\"apiKey\": \"" + api + "\""
                    + "}";

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://newsapi.org/v2/everything"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            String body = response.body();

            int titleIndex = body.indexOf("\"title\":");
            if (titleIndex == -1) return 0;

            int firstQuote = body.indexOf("\"", titleIndex + 8);
            int secondQuote = body.indexOf("\"", firstQuote + 1);

            if (firstQuote == -1 || secondQuote == -1) return 0;

            String title = body.substring(firstQuote + 1, secondQuote).trim();


            return title.length();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


}