class Solution {
    
     public int minimumBuckets(String hamsters) {

        if(hamsters.length() == 1) {
            if(hamsters.charAt(0) == '.') return 0;
            return -1;
        }

        int count = 0;
        StringBuilder sb = new StringBuilder(hamsters);
        for (int i = 0; i < hamsters.length(); i++) {
            if(i == 0 && sb.charAt(i) == 'H') {
                char right = sb.charAt(i + 1);
                if(right == 'H') return -1;
                count ++;
                sb.setCharAt(i + 1, 'A');
            }else if(i == hamsters.length() - 1 && sb.charAt(i) == 'H') {
                char left = sb.charAt(i - 1);
                if(left == 'H') return -1;
                else if (left == '.') {
                    count++;
                    sb.setCharAt(i - 1, 'A');
                }
            }else if (sb.charAt(i) == 'H') {
                int left = sb.charAt(i -1);
                int right = sb.charAt(i + 1);
                if(left == 'H' && right == 'H') return -1;

                if(left == '.' && right == 'H') {
                    count++;
                    sb.setCharAt(i -1, 'A');
                }
                else if(left != 'A' && right != 'H') {
                    count++;
                    sb.setCharAt(i + 1, 'A');
                }
            }
        }
      //  System.out.println(sb);
        return count;
    }
}