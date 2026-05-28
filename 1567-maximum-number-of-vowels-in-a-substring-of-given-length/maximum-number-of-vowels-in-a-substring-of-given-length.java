class Solution {
    public int maxVowels(String str, int k) {

    char[] arr = str.toCharArray();
    int n = arr.length;

    if (n < k) return 0;

    int i = 0;
    int j = k - 1;

    int count = 0;

    for (int x = 0; x < k; x++) {
        if (isVowel(arr[x])) count++;
    }

    int maxCount = count;

    i = 0;      
    j = k - 1;      

    while (j + 1 < n) {

        if (isVowel(arr[i])) count--;    
        if (isVowel(arr[j + 1])) count++;

        i++;
        j++;

        maxCount = Math.max(maxCount, count);
    }

    return maxCount;
}

private boolean isVowel(char c) {
    return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
}

}