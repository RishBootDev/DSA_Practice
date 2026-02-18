import java.util.ArrayList;
import java.util.List;

public class SequenceOfStrings {

    public List<String> stringSequence(String target) {

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < target.length(); j++) {

            if (sb.length() <= j) {
                sb.append('a');
                list.add(sb.toString());
            }

            char ch = target.charAt(j);
            char bh = sb.charAt(j);

            while (bh != ch) {
                bh = (bh == 'z') ? 'a' : (char) (bh + 1);
                sb.setCharAt(j, bh);
                list.add(sb.toString());
            }
        }

        return list;
    }
}
