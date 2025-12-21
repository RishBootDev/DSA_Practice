import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TalentedCipher {

    public static void main(String[] args) {
        System.out.println(caesarCipher("jfhdjfdsjflksfsdh-fjhdfhsdfjsdhfjsh",3));
    }

    public static String caesarCipher(String s, int k) {


        List<Pair> pairs=new ArrayList<>();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            char paired = (char) ('a' + (ch - 'a' + k) % 26);
            Pair pair = new Pair(ch, paired);
            System.out.println(ch + " -> " + pair.paired);
            pairs.add(pair);
        }

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            char paired = (char) ('A' + (ch - 'A' + k) % 26);
            Pair pair = new Pair(ch, paired);
            System.out.println(ch + " -> " + pair.paired);
            pairs.add(pair);
        }

        Map<Character,Character> map=new HashMap<>();

        for (Pair pair: pairs) {
            map.put(pair.ch,pair.paired);
        }

        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)>='a' && s.charAt(i)<='z' || s.charAt(i)>='A' && s.charAt(i)<='Z')
                sb.append(map.get(s.charAt(i)));
            else sb.append(s.charAt(i));
        }

        return sb.toString();

    }

    static class Pair{
        char ch;
        char paired;

        public Pair(char ch,char paired){
            this.ch=ch;
            this.paired=paired;
        }
    }
}
