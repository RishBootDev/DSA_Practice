class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        
        for(int i = 0; i <= num; i++) {
            StringBuilder sb = new StringBuilder(i+"");
            int a = Integer.parseInt(sb.reverse().toString());

            if(a + i == num) return true;
        }

        return false;
    }
}