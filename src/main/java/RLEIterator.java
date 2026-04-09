import java.util.ArrayList;
import java.util.List;



// this is a working approach but got memory limit exceeded
class RLEIterator {

    private List<Integer> fin;
    private int idx;

    public RLEIterator(int[] encoding) {
        this.fin = new ArrayList<>();
        this.idx = 0;

        for (int i = 0; i < encoding.length -1; i+=2) {
            int val = encoding[i+1];
            int freq = encoding[i];

            while (freq --> 0) this.fin.add(val);
        }
        // System.out.println(fin);
    }

    public int next(int n) {
        this.idx += n;

        if (this.idx > fin.size()) return -1;

        return fin.get(this.idx - 1);
    }
}

// this is accepted solution
class RleIterator{
    private int [] encoding;
    private int idx;

    public RleIterator(int [] encoding) {
        this.encoding = encoding;
        this.idx = 0;
    }

    public int next(int n) {

        while (this.idx < encoding.length && n > encoding[idx]) {
            n -= encoding[idx];
            this.idx += 2;
        }

        if (this.idx >= encoding.length) return -1;

        encoding[idx] -= n;
        return encoding[idx + 1];
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */