import java.util.HashMap;
import java.util.PriorityQueue;

class EventManagerPriority {
    private PriorityQueue<Pair> pq;
    private HashMap<Integer,Integer> map;
    public EventManagerPriority(int[][] events) {
        pq = new PriorityQueue<>((a,b)->{
            if(a.priority!=b.priority){
                return b.priority-a.priority;
            }
            return a.eventId-b.eventId;
        });
        map = new HashMap<>();
        for(int[] event:events){
            pq.offer(new Pair(event[0],event[1]));
            map.put(event[0],event[1]);
        }

    }

    public void updatePriority(int eventId, int newPriority) {
        pq.offer(new Pair(eventId,newPriority));
        map.put(eventId,newPriority);
    }

    public int pollHighest() {
        while(!pq.isEmpty()){
            Pair pr = pq.poll();
            if(map.containsKey(pr.eventId) && map.get(pr.eventId)==pr.priority){
                map.remove(pr.eventId);
                return pr.eventId;
            }
        }
        return -1;
    }

    static class Pair{
        int eventId;
        int priority;
        Pair(int eventId,int priority){
            this.eventId = eventId;
            this.priority = priority;
        }
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */