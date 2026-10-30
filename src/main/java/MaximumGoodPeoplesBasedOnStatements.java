import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumGoodPeoplesBasedOnStatements {


    public int maximumGood(int[][] statements) {
        return helper(statements, 0, new HashSet<>(), new HashSet<>());
    }

    public int helper(int [][]statements, int i, Set<Integer> good, Set<Integer> bad) {

        if(i == statements.length) {
            System.out.println("all the good peoples : " + good);
            System.out.println("all the bad peoples : " + bad);
            System.out.println("++++++++++++++++++++++++++++++++++++");
            return good.size();
        }
        int count = 0;
        for (int j = 0; j < statements[0].length; j++) {
            if(statements[i][j] == 1) {
                //  person is good
                if(bad.contains(j)) {
                    bad.remove(j);
                    good.add(j);
                    int temp = helper(statements, i + 1, good, bad);
                    count = Math.max(temp, count);
                    good.remove(j);
                    bad.add(j);
                }else {
                    good.add(j);
                    int temp = helper(statements, i + 1, good, bad);
                    count = Math.max(temp, count);
                    good.remove(j);
                }

                // person is bad
                if(good.contains(j)) {
                    good.remove(j);
                    bad.add(j);
                    int bemp = helper(statements, i + 1, good, bad);
                    count = Math.max(bemp, count);
                    bad.remove(j);
                    good.add(j);
                }
                else {
                    bad.add(j);
                    int bemp = helper(statements, i + 1, good, bad);
                    count = Math.max(bemp, count);
                    bad.remove(j);
                }
            }else if (statements[i][j] == 0) {
                // person is good
                if(good.contains(j)) {
                    good.remove(j);
                    bad.add(j);
                    int temp = helper(statements, i + 1, good, bad);
                    count = Math.max(count, temp);
                    bad.remove(j);
                    good.add(j);
                }else {
                    bad.add(j);
                    int temp = helper(statements, i + 1, good, bad);
                    count = Math.max(count, temp);
                    bad.remove(j);
                }
                // person is bad
                if(bad.contains(j)) {
                    bad.remove(j);
                    good.add(j);
                    int bemp = helper(statements, i + 1, good, bad);
                    count = Math.max(bemp, count);
                    good.remove(j);
                    bad.add(j);
                }else {
                    good.add(j);
                    int bemp = helper(statements, i + 1, good, bad);
                    count = Math.max(bemp, count);
                    good.remove(j);
                }
            }
        }
        return count;
    }

}

class Temp{
    public static void main(String[] args) {
        MaximumGoodPeoplesBasedOnStatements mm = new MaximumGoodPeoplesBasedOnStatements();
    }
}
