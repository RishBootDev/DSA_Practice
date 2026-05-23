class Solution {
    public String clearDigits(String s) {
        
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9') {
                if(!stack.isEmpty()) stack.pop();
            }else stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : stack) sb.append(ch);

        return sb.toString();
    }
}