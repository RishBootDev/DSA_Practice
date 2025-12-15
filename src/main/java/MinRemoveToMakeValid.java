import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinRemoveToMakeValid {

    public String minRemoveToMakeValid(String s) {

        Stack<Pair> stack=new Stack<>();
        Set<Integer> set=new HashSet<>();

        for(int i=0;i<s.length();i++){
            if(stack.isEmpty() && s.charAt(i)==')'){
                set.add(i);
                continue;
            }
            if(s.charAt(i)=='(') {
                stack.push(new Pair('(',i));
            }
            else if(s.charAt(i)==')') stack.pop();
        }

        for(Pair x: stack)  set.add(x.index);

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(!set.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();

    }

    static class Pair{
        char bracket;
        int index;

        public Pair(char bracket,int index){
            this.bracket=bracket;
            this.index=index;
        }
    }
}
