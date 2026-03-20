import java.util.Arrays;

class CheckIfAStringCanBreakAnotherString {

    public boolean checkIfCanBreak(String s1, String s2) {

        char[] arr = s1.toCharArray();
        char[] barr = s2.toCharArray();

        Arrays.sort(arr);
        Arrays.sort(barr);

        boolean s1BreaksS2 = true;
        boolean s2BreaksS1 = true;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < barr[i]) {
                s1BreaksS2 = false;
            }

            if (barr[i] < arr[i]) {
                s2BreaksS1 = false;
            }
        }

        return s1BreaksS2 || s2BreaksS1;
    }
}