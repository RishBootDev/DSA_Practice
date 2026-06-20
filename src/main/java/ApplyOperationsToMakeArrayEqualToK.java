public class ApplyOperationsToMakeArrayEqualToK {

    public int minOperations(int k) {

        int op = 0;
        int sum = 1;
        int count = 1;
        boolean flag = true;
        while(sum < k) {
            if(flag){
                sum += 1;
                flag = !flag;
            }
            else {
                sum += count;
                count++;
                flag = !flag;
            }
            op++;
        }
        return op;
    }
}
