class Solution {

    public int countCollisions(String directions) {

        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < directions.length(); i++) {

            char ch = directions.charAt(i);
            if (stack.isEmpty()) {

                if (ch == 'R' || ch == 'S')
                    stack.push(ch);
            }

            else if (ch == 'R') {
                stack.push(ch);
            }

            else if (ch == 'S') {
                while (!stack.isEmpty() && stack.peek() == 'R') {
                    stack.pop();
                    count++;
                }
                stack.push('S');
            }
            else if (ch == 'L') {
                if (stack.peek() == 'R') {
                    count += 2;
                    stack.pop();
                    while (!stack.isEmpty() && stack.peek() == 'R') {
                        stack.pop();
                        count++;
                    }
                    stack.push('S');
                }
                else if (stack.peek() == 'S') {
                    count++;
                }
            }
        }
        return count;
    }
}