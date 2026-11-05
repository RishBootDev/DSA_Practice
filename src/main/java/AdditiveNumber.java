import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

public class AdditiveNumber {

    public boolean isAdditiveNumber(String num) {
        return helper(num, 0, new ArrayList<>(), new StringBuilder());
    }

    public boolean helper(String num, int i, List<String> list, StringBuilder sb) {

        if(i == num.length()) {
            if(sb.isEmpty()) return false;
            if(sb.length() > 1 && sb.charAt(0) == '0') return false;
            list.add(sb.toString());
            if(list.size() < 3) {
                list.removeLast();
                return false;
            }
            for(int j = 0; j < list.size() - 2; j++) {
                BigInteger first = new BigInteger(list.get(j));
                BigInteger second = new BigInteger(list.get(j + 1));
                BigInteger third = new BigInteger(list.get(j + 2));

                if(!first.add(second).equals(third)) {
                    list.removeLast();
                    return false;
                }
            }
            list.removeLast();
            return true;
        }

        sb.append(num.charAt(i));
        boolean first = false;

        if(sb.length() == 1 || sb.charAt(0) != '0') {
            first = helper(num, i + 1, list, sb);
        }
        sb.deleteCharAt(sb.length() - 1);
        if(first) return true;
        if(sb.isEmpty()) return false;
        list.add(sb.toString());

        boolean second = helper(num, i, list, new StringBuilder());
        list.removeLast();

        return second;
    }

    public static void main(String[] args) {
        AdditiveNumber a = new AdditiveNumber();

        System.out.println(a.isAdditiveNumber("112358"));
        System.out.println(a.isAdditiveNumber("199100199"));
        System.out.println(a.isAdditiveNumber("1235"));
    }
}
