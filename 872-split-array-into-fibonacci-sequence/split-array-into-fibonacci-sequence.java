class Solution {
    
     private List<Integer> ans = new ArrayList<>();

    public List<Integer> splitIntoFibonacci(String num) {
        for (int i = 1; i < num.length(); i++) {
            String firstStr = num.substring(0, i);
            if(firstStr.length()>11) break;
            if (firstStr.length() > 1 && firstStr.charAt(0) == '0') break;

            for (int j = i + 1; j < num.length(); j++) {
                String secondStr = num.substring(i, j);
                if (secondStr.length() > 11) break;
                if (secondStr.length() > 1 && secondStr.charAt(0) == '0') break;

                long first = Long.parseLong(firstStr);
                long second = Long.parseLong(secondStr);

                if (first > Integer.MAX_VALUE || second > Integer.MAX_VALUE) break;

                List<Integer> list = new ArrayList<>();
                list.add((int) first);
                list.add((int) second);

                helper(num, j, first, second, new StringBuilder(), list);

                if (!ans.isEmpty()) return ans;
            }
        }
        return ans;
    }

    public void helper(String num, int i, long first, long second,
                       StringBuilder sb, List<Integer> list) {

        if (!ans.isEmpty()) return;
        if (i == num.length()) {
            if (sb.isEmpty() && list.size() >= 3) {
                ans = new ArrayList<>(list);
            }
            return;
        }

        sb.append(num.charAt(i));
        long temp = Long.parseLong(sb.toString());
        if (temp > Integer.MAX_VALUE) {
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        if (temp == first + second) {
            list.add((int) temp);
            helper(num, i + 1, second, temp, new StringBuilder(), list);
            list.removeLast();
        }
        if (!(sb.length() > 1 && sb.charAt(0) == '0')) {
            helper(num, i + 1, first, second, sb, list);
        }
        sb.deleteCharAt(sb.length() - 1);
    }
}