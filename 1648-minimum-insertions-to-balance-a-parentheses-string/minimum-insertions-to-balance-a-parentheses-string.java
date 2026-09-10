class Solution {
    
    public int minInsertions(String s) {

        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' && stack.isEmpty()) {
                stack.push(ch);
            }
            else if (ch == ')' && stack.isEmpty()) {
                count++;
                stack.push('(');
                stack.push(ch);
            }
            else if (ch == ')' && stack.peek() == '(') {
                stack.push(ch);
            }
            else if (ch == ')' && stack.peek() == ')') {
                stack.pop();
                stack.pop();
            }
            else if (ch == '(' && stack.peek() == ')') {
                count++;
                stack.pop();
                stack.pop();
                stack.push(ch);
            }
            else {
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            char top = stack.pop();

            if (top == '(') {
                count += 2;
            } else {
                count++;

                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            }
        }

        return count;
    }

}
