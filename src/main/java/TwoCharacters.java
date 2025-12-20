import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class TwoCharacters {

    public static void main(String[] args) {

        System.out.println(alternate("asdcbsdcagfsdbgdfanfghbsfdab"));
    }
    public static int alternate(String s) {

        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        int max = 0;

        for (char ch : set) {

            String temp = remove(s, ch);

            LinkedHashSet<Character> inner = new LinkedHashSet<>();
            for (int i = 0; i < temp.length(); i++) {
                inner.add(temp.charAt(i));
            }

            for (char br : inner) {

               String res=createString(s,ch,br);
               if(checkAlternate(res)) max=Math.max(max,res.length());
            }
        }
        return max;
    }


    public static String remove(String str,char ch){

        StringBuilder sb=new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)!=ch){
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    public static String createString(String str,char a,char b){

        StringBuilder sb=new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==a || str.charAt(i)==b) sb.append(str.charAt(i));
        }

        return sb.toString();
    }

    public static boolean checkAlternate(String str) {

        if (str.length() < 2) return false;

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }

        if (set.size() != 2) return false;

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                return false;
            }
        }

        return true;
    }

}
