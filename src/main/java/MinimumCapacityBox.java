public class MinimumCapacityBox {

    public int minimumIndex(int[] capacity, int itemSize) {

        int min = Integer.MAX_VALUE;

        for(int x : capacity) {
            if(x >= itemSize){
                min = Math.min(x, min);
            }
        }

        for (int i = 0; i < capacity.length; i++) {
            if(min == capacity[i]) return i;
        }
        return -1;
    }

}
