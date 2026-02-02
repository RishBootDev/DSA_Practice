import java.util.Random;

public class RandomPickWithWeight {

    private int [] w;

    public RandomPickWithWeight(int[] w) {
        this.w = w;
    }

    public int pickIndex() {
        Random rand = new Random();
        int random = rand.nextInt(this.w.length);

        return random;
    }

    public static void main(String[] args) {
        RandomPickWithWeight rd= new RandomPickWithWeight(new int [2]);


    }

}
