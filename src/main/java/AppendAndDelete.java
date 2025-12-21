public class AppendAndDelete {

    public static String appendAndDelete(String s, String t, int k) {


        int len=Math.max(s.length(),t.length());
        int temp=0;
        for (int i = 0; i <len ; i++) {
            if(s.charAt(i)==t.charAt(i)){
                temp=i;
            }else break;
        }

        int fromA=s.length()-temp;
        int fromB=t.length()-temp;

        if(fromA+fromB<=k) return "Yes";

        return "No";
    }

}
