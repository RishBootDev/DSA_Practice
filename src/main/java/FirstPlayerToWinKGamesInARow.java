import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class FirstPlayerToWinKGamesInARow {

    public int findWinningPlayer(int[] skills, int k) {

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int c : skills) q.offer(c);
        if(q.size() < 2) return 0;
        int count = 1;
        int prev = Math.max(q.poll(), q.poll());

        while(true) {
            if(count == k) return count;
            int first = q.poll();
            int second = q.poll();

            int temp = Math.max(first , second);
            if(temp == prev) {
                count++;
            }else {
                count = 1;
                prev = temp;
            }
            q.offerFirst(temp);
            q.offerLast(Math.min(first, second));
        }
    }
}
