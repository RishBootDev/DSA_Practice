class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        Map<Character, Integer> map = new HashMap<>();

        int j = 1;
        for(char i = 'a'; i <= 'z'; i++) {
            map.put(i, j++);
        }
        for(int i = 0; i< chars.length(); i++) {
            map.put(chars.charAt(i), vals[i]);
        }

        return Math.max(0, maxSubArray(s.toCharArray(), map));
    }

     public int maxSubArray(char []arr, Map<Character, Integer> map) {
        
        int currSum = map.get(arr[0]);
        int maxSum = map.get(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            
            currSum = Math.max(map.get(arr[i]), currSum + map.get(arr[i]));
            maxSum = Math.max(maxSum, currSum);
        }
        
        return maxSum;
    }
}