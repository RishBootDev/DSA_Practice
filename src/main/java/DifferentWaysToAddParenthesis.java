import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParenthesis {

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        helper(expression, ans);
        return ans;
    }
    public void helper(String expression, List<Integer> ans) {
        if(isNumber(expression)) {
            ans.add(expression.charAt(0) - '0');
        }

        for (int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i) < '0' || expression.charAt(i) > '9') {
                if(i == 0) continue;
                StringBuilder first = new StringBuilder();
                if(i - 2 >= 0) {
                    if(expression.charAt(i - 2) >= '0' && expression.charAt(i) <= '9') {
                        first.append(expression.charAt(i - 2) - '0');
                    }
                }
                first.append(expression.charAt(i - 1));

                StringBuilder second = new StringBuilder();
                if(i + 2 < expression.length()) {
                    if(expression.charAt(i + 2) >= '0' && expression.charAt(i) <='9') {
                        second.append(expression.charAt(i + 2) - '0');
                    }
                }
                second.append(expression.charAt(i + 1));

                int f = first.length() == 2 ? i - 2: i - 1;
                int s = second.length() == 2 ? i + 2 : i + 1;

                int a = Integer.parseInt(first.toString());
                int b = Integer.parseInt(second.toString());
                String str = "";
                if(expression.charAt(i) == '-') {
                    str = a - b + "";
                }else if (expression.charAt(i) == '+') {
                    str = a + b + "";
                }else {
                    str = a * b + "";
                }
                helper(expression.substring(0, f) + str + expression.substring(s), ans);
            }
        }
    }

    public boolean isNumber(String str) {
        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i) < '0' || str.charAt(i) >'9') return false;
        }
        return true;
    }
}
