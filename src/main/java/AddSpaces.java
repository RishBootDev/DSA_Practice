import java.util.Arrays;

public class AddSpaces {

    public String addSpaces(String s, int[] spaces) {

        StringBuilder sb = new StringBuilder();
       // Arrays.sort(spaces);
        int j = 0;

        for (int i = 0; i < s.length(); i++) {

            if (j < spaces.length && i == spaces[j]) {
                j++;
                sb.append(" ");
                sb.append(s.charAt(i));
            }else sb.append(s.charAt(i));

        }
        return sb.toString();
    }
}
