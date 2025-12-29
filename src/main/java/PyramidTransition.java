import java.util.*;

public class PyramidTransition {

    public static boolean pyramidTransition(String bottom, List<String> allowed) {


        // this method was the right attempt but it gave me concurrent modification exception due to
        // modifying the pyramid list inside the loop
        List<List<String>> pyramid=new ArrayList<>();

        List<String> bottoms = new ArrayList<>();
        bottoms.add(bottom);
        pyramid.add(bottoms);

        boolean isBeginning=false;

        Map<String,Character> map = new HashMap<>();

        for (int i = 0; i < allowed.size(); i++) {
            String temp = allowed.get(i);
            map.put(temp.substring(0,2),temp.charAt(2));   // constraint allowed[i].length() == 3
        }

        int count=0;

        for (List<String> list : pyramid) {

            if(count == bottom.length()) isBeginning = true;
            List<String> res = new ArrayList<>();

            for (String str : list) {
                StringBuilder sb=new StringBuilder();

                for (int i = 0; i < str.length()-1; i++) {
                    String temp = str.substring(i,i+2);

                    if(map.containsKey(temp)){
                        sb.append(map.get(temp));
                    }else if(isBeginning){
                        return true;
                    }else return false;
                }
                res.add(sb.toString());
            }

            pyramid.add(res);
        }
        return false;
    }

    static class Solution {

        // Backtracking final correct solution

        Map<String, List<Character>> map = new HashMap<>();

        public boolean pyramidTransition(String bottom, List<String> allowed) {

            for (String temp : allowed) {
                map.computeIfAbsent(
                        temp.substring(0, 2),
                        k -> new ArrayList<>()
                ).add(temp.charAt(2));
            }

            return helper(bottom);
        }
        private boolean helper(String curr) {

            if (curr.length() == 1) return true;

            return buildNext(curr, 0, new StringBuilder());
        }
        private boolean buildNext(String curr, int idx, StringBuilder sb) {

            if (idx == curr.length() - 1) {
                return helper(sb.toString());
            }

            String key = curr.substring(idx, idx + 2);
            if (!map.containsKey(key)) return false;

            for (char c : map.get(key)) {
                sb.append(c);
                if (buildNext(curr, idx + 1, sb)) return true;
                sb.deleteCharAt(sb.length() - 1); // backtrack
            }

            return false;
        }
    }



    public static boolean pyramidTransitionTwo(String bottom, List<String> allowed) {

        // this solution has passed 61 test cases out of 3 but failed when
        // the allowed list has multiple values for ex LL has A and B so
        // allowed contains LLA and LLB as well.
        int n = bottom.length();
        boolean isBeginning = false;

        Map<String,Character> map = new HashMap<>();

        for (int i = 0; i < allowed.size(); i++) {
            String temp = allowed.get(i);
            map.put(temp.substring(0,2),temp.charAt(2));   // constraint allowed[i].length() == 3
        }

        int count = 0;
        StringBuilder sb=new StringBuilder(bottom);

        while(n -- >0) {
            StringBuilder res= new StringBuilder();

            if (count == bottom.length()) isBeginning = true;

            for (int i = 0; i < sb.length() - 1; i++) {
                String temp = sb.substring(i, i + 2);

                if (map.containsKey(temp)) {
                    res.append(map.get(temp));
                } else if (isBeginning) {
                    return true;
                } else return false;
            }
            count++;
            sb = res;

        }
        return true;
    }


    public static void main(String[] args) {
        String bottom = "BCD";
        List<String> allowed = Arrays.asList("BCC","CDE","CEA","FFF");

        System.out.println(pyramidTransitionTwo(bottom, allowed));
    }
}
