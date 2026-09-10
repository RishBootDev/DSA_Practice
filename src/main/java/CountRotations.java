public class CountRotations {

    public int countRotations(String s, int k) {

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i + 1)) count++;
        }
        if(s.charAt(s.length() - 1) == s.charAt(0)) count++;
        if (k == count)
            return s.length() - count;

        if (k == count - 1)
            return count;

        return 0;
    }
}
