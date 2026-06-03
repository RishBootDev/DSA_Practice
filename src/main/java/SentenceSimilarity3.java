import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SentenceSimilarity3 {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {

        if(sentence1.equals(sentence2)) return true;

        int i = 0;
        int j = 0;
        List<Integer> idx = new ArrayList<>();

        String [] s1 = sentence1.split(" ");
        String [] s2 = sentence2.split(" ");

        int k = 0;
        int l = 0;

        while (k < s1.length && l < s2.length) {
            if (s1[k].equals(s2[l])) {
                idx.add(l);
                k++;
            }
            l++;
        }

        System.out.println(idx);
        return true;

    }

}
