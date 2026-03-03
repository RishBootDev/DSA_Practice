import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SearchSuggestionSystem {

    public static void main(String[] args) {
        // just revising the startswith method in Strings in java

        System.out.println("abc".startsWith("a"));
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        List<List<String>> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < searchWord.length(); i++) {

            sb.append(searchWord.charAt(i));
            String prefix = sb.toString();
            PriorityQueue<String> pq = new PriorityQueue<>();
            for (int j = 0; j < products.length; j++) {
                if (products[j].startsWith(prefix)) {
                    pq.add(products[j]);
                }
            }
            List<String> list = new ArrayList<>();
            ingest(list, pq);
            ans.add(list);
        }

        return ans;
    }

    public void ingest(List<String> list, PriorityQueue<String> pq) {
        for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
            list.add(pq.poll());
        }
    }
}
