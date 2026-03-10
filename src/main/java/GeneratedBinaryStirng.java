import java.util.ArrayList;

public class GeneratedBinaryStirng {

    public ArrayList<String> generateBinary(int n) {
        // code here

        ArrayList<String> ans = new ArrayList<>();

        for(int i = 1;i<=n;i++) {
            ans.add(
                    Integer.toBinaryString(i));
        }
        return ans;
    }
}
