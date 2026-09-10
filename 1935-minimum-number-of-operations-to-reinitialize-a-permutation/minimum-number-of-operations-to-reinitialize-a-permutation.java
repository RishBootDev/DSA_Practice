class Solution {

    public int reinitializePermutation(int n) {

        int[] per = new int[n];

        for (int i = 0; i < n; i++) {
            per[i] = i;
        }

        int count = 0;

        do {
            int[] temp = new int[n];

            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    temp[i] = per[i / 2];
                } else {
                    temp[i] = per[n / 2 + (i - 1) / 2];
                }
            }

            per = temp;
            count++;
        } while (!check(per));

        return count;
    }

    public boolean check(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i != arr[i]) return false;
        }

        return true;
    }
}