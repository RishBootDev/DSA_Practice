class Solution {
    public int countPairs(int[] nums) {
        int count = 0;
        String[] numStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrings[i] = Integer.toString(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                String str1 = numStrings[i];
                String str2 = numStrings[j];
                if (areAlmostEqual(str1, str2)) {
                    count++;
                }
            }
        }
        return count;
    }
    public boolean areAlmostEqual(String str1, String str2) {
        if (str1.length() > str2.length()) {
            str2 = padWithLeadingZeros(str2, str1.length());
        } else if (str2.length() > str1.length()) {
            str1 = padWithLeadingZeros(str1, str2.length());
        }
        if (str1.equals(str2)) {
            return true;
        }
        for (int i = 0; i < str1.length(); i++) {
            for (int j = i + 1; j < str1.length(); j++) {
                char[] arr1 = str1.toCharArray();
                swap(arr1, i, j);
                if (new String(arr1).equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }
    public String padWithLeadingZeros(String str, int length) {
        while (str.length() < length) {
            str = "0" + str;
        }
        return str;
    }
    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}