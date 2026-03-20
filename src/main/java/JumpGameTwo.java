import java.util.PriorityQueue;

public class JumpGameTwo {

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((p1,p2) -> p2.a+p2.b - p1.a - p1.b);
        int aliceScore = 0;
        int bobScore = 0;

        for (int i = 0; i < aliceValues.length; i++) {
            Pair pair = new Pair(aliceValues[i], bobValues[i]);
            pq.add(pair);
        }

        int i = 0;
        while(!pq.isEmpty()) {
            if(i%2 == 0) {
                aliceScore += pq.poll().a;
            }else bobScore += pq.poll().b;

            i++;
        }
        System.out.println(aliceScore);
        System.out.println(bobScore);

        if(aliceScore > bobScore) return 1;
        else if (aliceScore < bobScore) return -1;
        return 0;

    }

    static class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
