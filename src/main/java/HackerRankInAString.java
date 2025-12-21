public class HackerRankInAString {

    public static String hackerrankInString(String s) {


        String temp="hackerrank";
        int set=0;
        int count=0;

        for (int i = 0; i < temp.length(); i++) {
            for (int j = set; j <s.length() ; j++) {
                if(temp.charAt(i)==s.charAt(i)){
                    set=i+1;
                    count++;
                    break;
                }
            }
        }

        if(temp.length()==count) return "NO";

        return "YES";

    }
}
