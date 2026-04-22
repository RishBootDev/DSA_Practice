import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(String word : words) {
            if(sb.length() + word.length() + 1 <= maxWidth) {
                sb.append(word).append(" ");
            }
            else {
                ans.add(sb.toString());
                sb = new StringBuilder();
                sb.append(word);
            }
        }
        ans.add(sb.toString());
        System.out.println(ans);
        return ans;
    }
}
