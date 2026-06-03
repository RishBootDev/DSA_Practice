import java.util.HashSet;
import java.util.Set;

public class CanIWin {
    
    Set<Integer> set1 = new HashSet<>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
         boolean first = helper(maxChoosableInteger, 0, desiredTotal, true);
         boolean second = helper(maxChoosableInteger, 0, desiredTotal, false);

         return first || second;
        
    }
    public boolean helper(int mac, int temp, int total, boolean turn) {
        
        if(temp == total) return !turn;

        boolean ans = false;
        
        if(turn) {
            // player first choses
            for (int i = 1; i <= mac ; i++) {
                set1.add(i);
                ans = helper(mac, temp + i, total, false);
                set1.remove(i);
            }
        }else {
            // player second choses
            for (int i = 1; i <= mac; i++) {
                set1.add(i);
                ans |= helper(mac, temp + i, total, true);
                set1.remove(i);
            }
        }
        return ans;
    }
}
