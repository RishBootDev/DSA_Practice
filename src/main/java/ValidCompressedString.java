public class ValidCompressedString {

    public static int checkCompressed(String s, String t) {

        char temp=s.charAt(0);
        int j=0;

        for (int i = 0; i < t.length(); i++) {

            if(t.charAt(i)>='0' && t.charAt(i)<='9'){
                int num=t.charAt(i)-'0';
                j+=num+1;
            }else if(t.charAt(i)!=s.charAt(j)){
                return 0;
            }else j++;
        }
        return 1;
    }
}
