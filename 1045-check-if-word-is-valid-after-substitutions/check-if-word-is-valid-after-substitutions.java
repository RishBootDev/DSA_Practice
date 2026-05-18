class Solution {
    
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'c') {
                if(!stack.isEmpty() && stack.peek() == 'b') {
                    stack.pop();
                    if(!stack.isEmpty() && stack.peek() == 'a') {
                        stack.pop();
                    }else return false;
                }else return false;
            }else stack.push(s.charAt(i));
        }
        
        return stack.isEmpty()?true: false;
    }
}