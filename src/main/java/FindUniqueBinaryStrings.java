import java.util.HashSet;
import java.util.Set;

import java.util.HashSet;
import java.util.Set;

public class FindUniqueBinaryStrings {

    public String findDifferentBinaryString(String[] nums) {

        int n = nums[0].length();

        HashSet<String> original = new HashSet<>();
        for (String s : nums) {
            original.add(s);
        }
        HashSet<String> all = new HashSet<>();
        generate("01", n, "", all);

        for (String s : all) {
            if (!original.contains(s)) {
                return s;
            }
        }

        return "";
    }

    public static void generate(String letters, int n, String current, Set<String> set) {
        if (current.length() == n) {
            set.add(current);
            return;
        }

        for (int i = 0; i < letters.length(); i++) {
            generate(letters, n, current + letters.charAt(i), set);
        }
    }
}