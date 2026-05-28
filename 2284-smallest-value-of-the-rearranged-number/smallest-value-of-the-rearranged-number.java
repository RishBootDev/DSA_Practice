import java.util.Arrays;

class Solution {
    public long smallestNumber(long num) {
        if (num == 0) return 0;

        if (num > 0) {
            char arr[] = String.valueOf(num).toCharArray();
            Arrays.sort(arr);
            
            if (arr[0] == '0') {
                for (int i = 1; i < arr.length; i++) {
                    if (arr[i] != '0') {
                        char temp = arr[0];
                        arr[0] = arr[i];
                        arr[i] = temp;
                        break;
                    }
                }
            }
            return Long.parseLong(new String(arr));
        } else {
            char arr[] = String.valueOf(num).substring(1).toCharArray();
            Arrays.sort(arr);
            for (int i = 0; i < arr.length / 2; i++) {
                char temp = arr[i];
                arr[i] = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = temp;
            }

            return Long.parseLong(new String(arr)) * (-1);
        }
    }
}