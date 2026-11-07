import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates {

    private List<String> ans;

    public List<String> ambiguousCoordinates(String s) {
        this.ans = new ArrayList<>();
        helper(s, 1, new ArrayList<>(), new StringBuilder(), 0, false);
        return this.ans;
    }

    public void helper(String s, int i, List<String> list,
                       StringBuilder sb, int count, boolean dot) {

        if (i == s.length() - 1) {
            if (count == 1 && isValid(sb.toString())) {
                ans.add("(" + list.getFirst() + ", " + sb + ")");
            }
            return;
        }

        sb.append(s.charAt(i));
        helper(s, i + 1, list, sb, count, dot);
        sb.deleteCharAt(sb.length() - 1);

        if (!dot) {
            sb.append(s.charAt(i)).append('.');
            helper(s, i + 1, list, sb, count, true);
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (count == 0 && !sb.isEmpty() && isValid(sb.toString())) {
            list.add(sb.toString());
            helper(s, i, list, new StringBuilder(), 1, false);
            list.removeLast();
        }
    }

    public boolean isValid(String str) {
        if (str.isEmpty()) return false;

        if (str.contains(".")) {
            String[] parts = str.split("\\.", -1);

            if (parts.length != 2 || parts[0].isEmpty()
                    || parts[1].isEmpty()) return false;
            if (parts[0].length() > 1 && parts[0].charAt(0) == '0')
                return false;
            if (parts[1].charAt(parts[1].length() - 1) == '0')
                return false;
            return true;
        }
        return str.length() == 1 || str.charAt(0) != '0';
    }

    public static void main(String[] args) {
        AmbiguousCoordinates ob = new AmbiguousCoordinates();

        System.out.println(ob.ambiguousCoordinates("(123)"));
        System.out.println(ob.ambiguousCoordinates("(1233)"));
        System.out.println(ob.ambiguousCoordinates("(00011)"));
    }
}