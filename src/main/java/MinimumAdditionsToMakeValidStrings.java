import java.util.Stack;

public class MinimumAdditionsToMakeValidStrings {

    public int addMinimum(String word) {

        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i = 0; i < word.length(); i++) {
            if(stack.isEmpty() && word.charAt(i) == 'b') count++;
            else if (stack.isEmpty() && word.charAt(i) == 'c') count+=2;
            else {
                char top = stack.peek();
                char ch = word.charAt(i);
                if(top == 'a' && ch == 'c') count++;
                if(top == 'b' && ch == 'a') count++;
                if(top == 'c' && ch == 'b') count++;
            }
            stack.push(word.charAt(i));
        }
        return count;

    }
}
