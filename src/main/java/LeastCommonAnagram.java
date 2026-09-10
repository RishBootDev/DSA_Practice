import java.util.*;

public class LeastCommonAnagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();

        String[] arr = new String[a];
        for (int i = 0; i < a; i++) {
            arr[i] = sc.next();
        }
        if (a == 0) {
            return;
        }

        Map<Character, Integer> map = new HashMap<>();

        String firstStr = arr[0];
        for (int i = 0; i < firstStr.length(); i++) {
            char ch = firstStr.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 1; i < a; i++) {
            String str = arr[i];
            Map<Character, Integer> freq = new HashMap<>();
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            }

            List<Character> keys = new ArrayList<>(map.keySet());
            for (char ch : keys) {
                if (freq.containsKey(ch)) {
                    map.put(ch, Math.min(map.get(ch), freq.get(ch)));
                } else {
                    map.remove(ch);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (map.containsKey(ch)) {
                int count = map.get(ch);
                for (int k = 0; k < count; k++) {
                    result.append(ch);
                }
            }
        }
        if (result.length() > 0) {
            System.out.println(result.toString());
        } else {

        }
    }
}