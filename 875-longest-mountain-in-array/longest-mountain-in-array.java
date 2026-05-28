class Solution {
    
    public int longestMountain(int[] arr) {

        List<Integer> mt = new ArrayList<>();
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                mt.add(i);
            }
        }
        int max = 0;
        for (int c : mt) {
            int left = c;
            int right = c;
            while (left > 0 && arr[left] > arr[left - 1]) {
                left--;
            }
            while (right < arr.length - 1 &&
                    arr[right] > arr[right + 1]) {
                right++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}