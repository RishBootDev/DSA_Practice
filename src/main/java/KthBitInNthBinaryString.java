public class KthBitInNthBinaryString {

    public char findKthBit(int n, int k) {

        String str = "0";
        while(n --> 0) {
            StringBuilder sb = new StringBuilder(invert(str));
            str = str + "1" + sb.reverse();
        }

        System.out.println(str);
        return str.charAt(k+1);
    }

    public String invert(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '0') sb.append(1);
            else sb.append(0);
        }
        return sb.toString();
    }
}
