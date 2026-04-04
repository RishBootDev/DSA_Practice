import java.util.ArrayList;

public class AbsoluteDifferenceTemp {


    // this is the brute force approach and passed 10/ 100 test cases
    public static ArrayList<Long> absDifOne(long n) {

        ArrayList<Long> ans = new ArrayList<>();
        for (int i = 10; i <= n; i++) {
            if(check(i)) ans.add((long)i);
        }

        return ans;
    }

    public static boolean check(long n) {
        String str = String.valueOf(n);

        for (int i = 0; i < str.length() - 1; i++) {
        //    System.out.println(str.charAt(i+1) - str.charAt(i));
            if(Math.abs(str.charAt(i+1) - str.charAt(i)) == 1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(absDifOne(12));
    }
}
