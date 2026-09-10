import java.util.ArrayDeque;

public class FrontMiddleBackQueue {

    ArrayDeque<Integer> first;
    ArrayDeque<Integer> second;
    public FrontMiddleBackQueue() {
         first = new ArrayDeque<>();
         second = new ArrayDeque<>();
    }

    public void pushFront(int val) {
       if(first.size() == second.size()) {
           first.offerLast(val);
           int temp = first.removeLast();
           second.offerFirst(temp);
       }else {
           first.offerFirst(val);
       }
    }

    public void pushMiddle(int val) {
        if(first.size() == second.size()) {
            second.offerFirst(val);
        }else if (first.size() < second.size()) {
            first.offerLast(val);
        }
    }

    public void pushBack(int val) {
        if(first.size() == second.size()) {
            second.offerLast(val);
        }else {
            second.offerLast(val);
            int temp = second.removeFirst();
            first.offerLast(temp);
        }
    }

    public int popFront() {
        if(first.size() == second.size()) {
            return first.removeFirst();
        }else {
            int temp = first.removeFirst();
            int bemp = second.removeLast();
            first.offerLast(bemp);
            return temp;
        }
    }

    public int popMiddle() {
         if(first.size() == second.size()) return first.removeLast();
         return second.removeFirst();
    }

    public int popBack() {
         if(first.size() == second.size()) {
            int poll =  second.removeLast();
             int temp = first.removeLast();
             second.offerFirst(temp);
             return poll;
         }else {
             return second.removeLast();
         }
    }
}
