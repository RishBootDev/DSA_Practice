import java.util.ArrayList;
import java.util.List;

public class SubStringWithConcatenationOfAllWords {
    // Brute force approach
    public List<Integer> findSubstring(String s, String[] words) {

        int len=0;

        for(String text: words){
            len+=text.length();
        }

        if(s.length()<len) return new ArrayList<>();

        List<Integer> list=new ArrayList<>();

        outer:
        for (int i = 0; i < s.length()-len; i++) {

            String temp=s.substring(i,i+len);

            for (String word: words){
                if(!temp.contains(word)){
                    continue outer;
                }
            }

            list.add(i);
        }

        return list;
    }
}
