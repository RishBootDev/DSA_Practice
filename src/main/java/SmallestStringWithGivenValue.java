public class SmallestStringWithGivenValue {

    public String getSmallestString(int n, int k) {

        StringBuilder sb = new StringBuilder();
        for (int i = 26; i >= 1 ; i--) {

            int temp = n/i;
            char ch = (char)(i + 96);
            while(temp --> 0) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
