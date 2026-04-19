public class TimeNeededToArrangeABinarytString {

    public int secondsToRemoveOccurrences(String s) {

        char [] arr= s.toCharArray();
        int ans = 0;

        while (count(arr) != 0) {
            invert(arr);
            ans ++;
        }
        return ans;

    }

    public int count(char arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] =='0' && arr[i+1] == '1') count++;
        }
        return count;
    }

    public void invert(char arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] =='0' && arr[i+1] == '1') {
                arr[i+1] = '0';
                arr[i] = '1';
                i++;
            }
        }
    }

    // this is the more optimized solution of this problem
    public int secondsToRemoveOccurrences2(String s) {

        int zeros = 0;
        int time = 0;
        for (char c : s.toCharArray()) {

            if (c == '0') {
                zeros++;
            } else {

                if (zeros > 0) {
                    time = Math.max(time + 1, zeros);
                }
            }
        }

        return time;
    }
    //  0 1 1 0 1 0 1
}
