import java.util.ArrayList;
import java.util.List;

public class ShortEncodingOfWords {

    public int minimumLengthEncoding(String[] words) {

        List<String> list = new ArrayList<>();

        first :
        for (int i = 0; i < words.length; i++) {
            String a = words[i];
            for (int j = 0; j < words.length; j++) {
                if(i == j) continue;
                String b = words[j];
                if(a.length() > b.length()) continue;

                if(b.contains(a) && b.endsWith(a)) {
                    continue first;
                }
            }
            list.add(a);
        }
        int ans = 0;
        for(String str : words) {
            ans += str.length() + 1;
        }
        return ans;
    }
}
