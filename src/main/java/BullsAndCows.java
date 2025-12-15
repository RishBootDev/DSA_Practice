import java.util.HashSet;
import java.util.Set;

public class BullsAndCows {
    public static void main(String[] args) {


    }

    public String getHint(String secret, String guess) {

        Set<Character> set=new HashSet<>();
        Set<Integer> indices=new HashSet<>();

        int count=0;

        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                count++;
                indices.add(i);
            }

            else set.add(secret.charAt(i));
        }

        int temp=0;

        for (int i = 0; i < guess.length(); i++) {
            if(!indices.contains(i)) temp++;
        }


        return count+"A"+temp+"B";

    }
}
