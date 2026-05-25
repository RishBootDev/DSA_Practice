import java.util.ArrayList;
import java.util.List;


public class KthSymbolInGrammar {

    // this is the correct recursion but got issues due to large time complexity
    public int kthGrammar(int n, int k) {

        List<String> list = new ArrayList<>();
        list.add("0");
        helper(1, n, "0", list);
        return list.get(n - 1).charAt(k - 1) - '0';
    }

    public void helper(int row, int n, String str, List<String> list) {
        if (row == n) return;
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) == '0') {
                sb.append("01");
            } else {
                sb.append("10");
            }
        }
        list.add(sb.toString());
        helper(row + 1, n, sb.toString(), list);
    }
}
