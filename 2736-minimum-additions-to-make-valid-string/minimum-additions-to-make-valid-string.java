class Solution {
    
    public int addMinimum(String word) {

        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i = 0; i < word.length(); i++) {
            if(stack.isEmpty() && word.charAt(i) == 'a');
            else if(stack.isEmpty() && word.charAt(i) == 'b') count++;
            else if (stack.isEmpty() && word.charAt(i) == 'c') count+=2;
            else {
                char top = stack.peek();
                char ch = word.charAt(i);
                if(top == 'a' && ch == 'c') count++;
                if(top == 'a' && ch == 'a') count+=2;
                if(top == 'b' && ch == 'a') count++;
                if(top == 'b' && ch == 'b') count+=2;
                if(top == 'c' && ch == 'b') count++;
                if(top == 'c' && ch == 'c') count+=2;
            }
            stack.push(word.charAt(i));
        }
        if(stack.peek() =='a') count+=2;
        else if(stack.peek() == 'b') count++;
        return count;

    }
}