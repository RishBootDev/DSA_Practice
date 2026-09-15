import java.util.ArrayDeque;
import java.util.Scanner;

public class TicketQueue {


    // this is the simulation approach for the problem
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int arr[] = new int[a];
        ArrayDeque<Pair> dq = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            dq.add(new Pair(i, arr[i]));
        }
        int ans = 0;
        while(!dq.isEmpty()) {
            Pair pair = dq.pollFirst();
            ans ++;
            if(pair.id == b) {
                if(pair.duration == 1) {
                    break;
                }else {
                    pair.duration--;
                    dq.offerLast(pair);
                }
            }else {
                if(pair.duration > 1) {
                    pair.duration--;
                    dq.offerLast(pair);
                }
            }
        }
        System.out.println(ans);

    }
    static class Pair{
        int id;
        int duration;
        public Pair(int id, int duration) {
            this.id = id;
            this.duration = duration;
        }
    }
}
