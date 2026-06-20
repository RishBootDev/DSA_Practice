public class MinimumNumberOfSwapsToMakeBinaryStringAlternating {

    public int minSwaps(String s) {

        int count1 = count(s, '1');
        int count0 = count(s, '0');
        if (s.length() % 2 == 0) {
            if(count1 != count0) return -1;
            StringBuilder sb1 = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if(i % 2== 0) {
                    sb1.append('0');
                }else sb1.append('1');
            }
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if(i % 2== 0) {
                    sb2.append('0');
                }else sb2.append('1');
            }
            int temp1 = match(s, sb1.toString());
            int temp2 = match(s, sb2.toString());
            return temp1 > temp2?temp2/2 : temp1/2;
        }else{
            if(count1 == count0 + 1) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    if(i % 2==0) sb.append('1');
                    else sb.append('0');
                }
                return match(s, sb.toString())/2;
            }else if (count0 == count1 + 1) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    if(i % 2==1) sb.append('1');
                    else sb.append('0');
                }
                return match(s, sb.toString())/2;
            }else return -1;
        }

    }

    public int match(String s, String sb) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != sb.charAt(i)) count++;
        }
        return count;
    }

    public int count(String s, char ch) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ch) count++;
        }
        return count;
    }
}
