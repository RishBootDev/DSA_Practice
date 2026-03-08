import java.util.Arrays;

class MinimumOperationsTOSortAString {
    public int minOperations(String s) {
        int n = s.length();
        if(n == 1) return 0;

        char[] sort = s.toCharArray();
        Arrays.sort(sort);

        String t = new String(sort);

        if(s.equals(t)) return 0;

        if(n == 2) return -1;

        int first = s.indexOf(sort[0]);
        int last = s.lastIndexOf(sort[n - 1]);

        if(first == 0 || last == n - 1){
            return 1;
        }

        if(first == n - 1 && last == 0){
            for(int i = 1; i < n - 1; i++){
                if(s.charAt(i) == sort[0] || s.charAt(i) == sort[n - 1]){
                    return 2;
                }
            }
            return 3;
        }

        return 2;
    }
}