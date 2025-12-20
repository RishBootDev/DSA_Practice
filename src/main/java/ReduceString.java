import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ReduceString {
    public static String superReducedString(String s) {
        // Write your code here

        Set<Character> set=new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        while(set.size()!=s.length()){

            s=reduceElement(s);
            set=new HashSet<>();

            for (int i = 0; i < s.length(); i++) {
                set.add(s.charAt(i));
            }
        }

        return s;
    }
    public static String reduceElement(String str){
        StringBuilder sb=new StringBuilder();

        for (int i = 0; i < str.length()-1; i++) {
            if(str.charAt(i)!=str.charAt(i+1)){
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    public static String reduceUsingStack(String s){

        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (stack.length() > 0 && stack.charAt(stack.length() - 1) == ch) {
                stack.deleteCharAt(stack.length() - 1); // remove pair
            } else {
                stack.append(ch);
            }
        }

        return s;
    }
}
