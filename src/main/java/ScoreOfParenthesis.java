import java.util.Stack;

public class ScoreOfParenthesis {

    public int scoreOfParentheses(String s) {

        Stack<Character> stack = new Stack<>();
        int count = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == '('){
                stack.push('(');
                count++;
            }else {
                ans += count;
                stack.pop();
            }

        }
        return ans;
    }
}
