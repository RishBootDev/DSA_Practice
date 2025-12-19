import java.util.Arrays;

public class ChooseAndSwap {

    public static void main(String[] args) {
        System.out.println(chooseAndSwap("azby"));

    }

    public static String chooseAndSwap(String str){

        char[] suffix=new char[str.length()];
        char min=Character.MAX_VALUE;
        for (int i = str.length()-1; i >=0 ; i--) {
             if(str.charAt(i)<min){
                 min=str.charAt(i);
             }
             suffix[i]=min;
        }

        for (int i = 0; i < str.length(); i++) {

            char ch=str.charAt(i);
            char temp=suffix[i];

            if(ch>temp){

               String ans=swap(ch,temp,str);
               if(ans.compareTo(str)<0) return ans;
            }
        }

        System.out.println(Arrays.toString(suffix));
        return str;
    }

    public static String swap(char first,char second,String str){

        StringBuilder sb=new StringBuilder(str);

        for (int i = 0; i < str.length(); i++) {

            if(sb.charAt(i)==first){
                sb.setCharAt(i,second);
            }else if (sb.charAt(i)==second){
                sb.setCharAt(i,first);
            }
        }
        return sb.toString();
    }
}
