public class MinimumSuffixFlips {

    public int minFlips(String target) {

        int count = countGroups(target);
        if(target.charAt(0) == '0') return count-1;

        return count;

    }

    public int countGroups(String str) {
        int count = 0;

        for (int i = 0; i < str.length() - 1; i++) {

            if(str.charAt(i) != str.charAt(i + 1)) count++;
        }
        count++;
        return count;
    }
}
