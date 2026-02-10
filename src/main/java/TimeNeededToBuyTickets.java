import java.util.LinkedList;
import java.util.Queue;

public class TimeNeededToBuyTickets {


    public int timeRequiredToBuy(int tickets[],int k){

        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < tickets.length; i++) {

            Pair pair = new Pair(tickets[i]);
            if(i==k-1){
                pair.target= true;
            }

            queue.add(pair);
        }

        System.out.println(queue);

        boolean flag = true;

        while(!flag){
            Pair temp = queue.poll();

            temp.a--;

            if(temp.target && temp.a == 0){
                flag = false;
                break;
            }
            queue.add(temp);
        }
        return 0;
    }

    static class Pair{
        int a;
        boolean target;

        public Pair(int a){
            this.a = a;
        }

        public String toString(){
            return this.a +" "+this.target;
        }
    }
}
