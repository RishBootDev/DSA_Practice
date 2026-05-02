class Solution {
    public int rotatedDigits(int n) {

        int count = 0;
        
        for(int i = 1; i <= n; i++) {
            String str = String.valueOf(i);
            if(str.contains("2") || str.contains("5") || str.contains("6") || str.contains("9")) {
                if(!str.contains("3") && !str.contains("4") && !str.contains("7"))              count++;
            }
        }

        return count;
    }
}

// we need a number that that contains 2 or 5 or 6 or 9 but do not contains 3,4,7