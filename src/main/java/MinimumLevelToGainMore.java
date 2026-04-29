public class MinimumLevelToGainMore {

    public int minimumLevels(int[] possible) {

        int pre[] = new int[possible.length];
        int suf[] = new int[possible.length];

        int sum = 0;
        for (int i = 0; i < possible.length; i++) {
            if(possible[i] != 0) sum += 1;
            else sum += -1;

            pre[i] = sum;
        }

        sum = 0;
        for (int i = possible.length -1; i >= 0 ; i--) {
            if(possible[i] != 0) sum += 1;
            else sum -=1;

            suf[i] += sum;
        }

        for (int i = 0; i < possible.length - 1; i++) {
            if(pre[i]> suf[i+1]) return i;
        }
        return -1;
    }
}
