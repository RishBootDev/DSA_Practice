public class IncrementalMemoryLeaks {

    public int[] memLeak(int memory1, int memory2) {

        int i = 1;

        while(memory2 >= i || memory1 - i >= 0) {
            if(memory2 > memory1) {
                //  if(memory2 - i < 0) break;
                memory2 -= i;
            }
            else {
                //  if(memory1 - i < 0) break;
                memory1 -= i;
            }
            i++;
        }

        return new int[]{i, memory1, memory2};
    }
}
