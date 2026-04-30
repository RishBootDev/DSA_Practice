import java.util.List;


// got a correct and working approach but because of line 19 we are getting memory limit exceeded error
public class SnapShotArray {

    private List<int []> shot;
    private int arr[];

    public SnapShotArray(int length) {
          this.arr = new int[length];
    }

    public void set(int index, int val) {
        this.arr[index] = val;
    }

    public int snap() {
        int[] copy = arr.clone();
        shot.add(copy);
        return shot.size() - 1;
    }

    public int get(int index, int snap_id) {
        return this.shot.get(index)[snap_id];
    }
}
