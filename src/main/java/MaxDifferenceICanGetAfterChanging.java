public class MaxDifferenceICanGetAfterChanging {

    public int maxDiff(int num) {

        StringBuilder sb = new StringBuilder(String.valueOf(num));

        char first = sb.charAt(0);
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == first)
               sb.setCharAt(i, '9');
        }
        int a = Integer.parseInt(sb.toString());

        for (int i = 1; i < sb.length() ; i++) {
            if(sb.charAt(i) == '9')
                sb.setCharAt(i, '0');
        }
        sb.setCharAt(0, '1');
        return a - Integer.parseInt(sb.toString());

    }
}
