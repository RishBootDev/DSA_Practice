public class StoneGame {

    public boolean stoneGame(int[] piles) {
      return helper(piles, 0, piles.length -1, 0, 0, true);
    }
    public boolean helper(int piles[], int i, int j, int a , int b, boolean flag) {
        if(i == j){
            if(flag) {
                if(piles[i] + a > b) return true;
                return false;
            }else {
                if(piles[i] + b > a) return false;
                return true;
            }
        }

        // Alice options
        // take first and skip last
        if(flag) {
            boolean ans1 = helper(piles, i + 1, j, a + piles[i], b, false);
            boolean ans2 = helper(piles, i, j - 1, a + piles[j], b, false);
            return ans1 || ans2;
        }else {
            // bob options
            boolean ans3 = helper(piles, i + 1, j, a, b + piles[i], true);
            boolean ans4 = helper(piles, i, j - 1, a, b + piles[j], true);
            return ans3 && ans4;
        }
    }
}
