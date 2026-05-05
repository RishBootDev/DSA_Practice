public class MaximumSwap {

    public int maximumSwap(int num) {
        char[] ch = String.valueOf(num).toCharArray();

        char max = Character.MIN_VALUE;
        for(char c : ch) {
            max = (char) Math.max(c, max);
        }

        int idx = 0;
        for (int i = 0; i < ch.length; i++) {
            if(ch[i] == max) idx = i;
        }
        ch[idx] = ch[0];
        ch[0] = max;
        return Integer.parseInt(new String(ch));
    }
}
