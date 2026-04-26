

// this solution beats 100 percent
public class ConsecutiveDataStream {

    private int t;
    private int k;
    private int value;

    public ConsecutiveDataStream(int value, int k) {
         this.k = k;
         this.value = value;
         this.t = 0;
    }

    public boolean consec(int num) {

       if(this.value == num) this.t++;
       else return false;

       return this.t >= this.k;
    }
}
