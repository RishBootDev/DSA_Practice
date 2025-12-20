public class BinaryStringChange {
    public static int beautifulBinaryString(String b) {

        StringBuilder sb=new StringBuilder(b);
        int count=0;

        for (int i = 0; i < sb.length()-2; i++) {
            if(sb.charAt(i)=='0' && sb.charAt(i+1)=='1' && sb.charAt(i+2)=='0'){
                sb.setCharAt(i+2,'1');
                count++;
            }
        }

        return count;
    }
}
