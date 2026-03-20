import java.util.ArrayDeque;

public class StoneGameFirst {

    public static boolean stoneGame(int[] piles) {

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int x : piles) {
            deque.offer(x);
        }

        return helper(deque, 0, 0);
    }

    public static boolean helper(ArrayDeque<Integer> deque, int sum, int bum) {
        if(deque.isEmpty()) {
            if(sum > bum) return true;
            return false;
        }

        int first = deque.pollFirst();
        int last = deque.pop();

        boolean case1= helper(deque, sum + first, bum + last);
        boolean case2 = helper(deque, sum + last, bum + first);

        return case1 || case2;
    }

    public static void main(String[] args) {
        int arr[] = {3,3,3,3};
        System.out.println(stoneGame(arr));
    }

}
