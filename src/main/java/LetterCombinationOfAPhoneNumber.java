import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        helper(digits, 0, new StringBuilder(), ans);
        return ans;
    }
    public void helper(String digits, int i, StringBuilder sb, List<String> ans) {
        if(i == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        String temp = map(digits.charAt(i));
        for (int j = 0; j < temp.length(); j++) {
            sb.append(temp.charAt(j));
            helper(digits, i + 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public String map(char digit) {
        if(digit == '1') return "";
        else if (digit == '2') return "abc";
        else if(digit == '3') return "def";
        else if (digit == '4') return "ghi";
        else if(digit == '5') return "jkl";
        else if (digit == '6') return "mno";
        else if(digit == '7') return "pqrs";
        else if (digit == '8') return "tuv";
        else return "wxyz";
    }
}
