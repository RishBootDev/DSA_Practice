class Solution {
    public String resultingString(String s) {
        
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty() && isConsecutive(stack.peek(), s.charAt(i))) {
                stack.pop();
            }else stack.push(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : stack) sb.append(ch);

        return sb.toString();
    }

    public boolean isConsecutive(char c1 , char c2) {

        if(c1 == 'a' && c2 =='z') return true;
        else if(c1 == 'z' && c2 == 'a') return true;

        return Math.abs(c1 - c2) == 1? true : false;
    }
}