import java.util.*;

public class BasicCalculator2 {

    public int calculate(String s) {

        Stack<Integer> values = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int i = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                i++;
                continue;
            }

            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                values.push(num);
                continue;
            }

            while (!ops.isEmpty() && pref(ops.peek()) >= pref(ch)) {
                int b = values.pop();
                int a = values.pop();
                char op = ops.pop();
                values.push(apply(a, b, op));
            }

            ops.push(ch);
            i++;
        }

        while (!ops.isEmpty()) {
            int b = values.pop();
            int a = values.pop();
            char op = ops.pop();
            values.push(apply(a, b, op));
        }
        return values.peek();
    }

    public int pref(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        return -1;
    }

    public int apply(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }
}