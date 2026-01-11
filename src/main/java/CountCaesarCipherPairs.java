import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountCaesarCipherPairs {

    public static void main(String[] args) {

        System.out.println(countPairs(new String[]{"ab","aa","za","aa"}));
    }

    public static long countPairs(String [] words) {

        Map<String, Integer> map = new HashMap<>();

        for(String str : words) {
            String res = converter(str);
            map.put(res, map.getOrDefault(res,0)+1);
        }

        List<Integer> values = new ArrayList<>(map.values());

        long ans = 0;
        for (Integer value : values) {
            ans += ((long) value *(value-1))/2;
        }
        System.out.println(map);

        return ans;
    }

    public static String converter(String str) {

        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < str.length() - 1; i++) {
            int diff = (str.charAt(i + 1) - str.charAt(i) + 26) % 26;
            temp.add(diff);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('a');

        for (int i = 0; i < temp.size(); i++) {
            char prev = sb.charAt(sb.length() - 1);
            char next = (char) ((prev - 'a' + temp.get(i)) % 26 + 'a');
            sb.append(next);
        }

        return sb.toString();
    }

}
