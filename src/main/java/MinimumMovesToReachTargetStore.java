public class MinimumMovesToReachTargetStore {

    public int minMoves(int target, int maxDoubles) {

        int temp = maxDoubles;
        int count = 0;

        while(target != 1) {
            if(temp > 0 && target % 2==0) {
                temp--;
                target-= target/2;
            }
            else target--;
            count++;
        }

        return count;
    }
}
