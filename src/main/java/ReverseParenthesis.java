import java.util.Stack;

public class ReverseParenthesis {

    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push("(");
            }else if (s.charAt(i) == ')') {
                StringBuilder sb = new StringBuilder(stack.pop());
                sb.reverse();
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(sb.toString());
                }else {
                    String str = stack.pop();
                    stack.push(str + sb.toString());
                }
            }else {
               if(stack.peek().equals("(")) {
                   stack.push(s.charAt(i)+"");
               }else {
                   String str = stack.pop();
                   stack.push(str + s.charAt(i));
               }
            }
        }
        return stack.peek();
    }
}
