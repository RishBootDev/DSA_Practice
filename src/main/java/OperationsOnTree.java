import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OperationsOnTree {

    private List<List<Integer>> pat;
   private List<List<Integer>> tree;
   private Map<Integer, Integer> lock;

   public OperationsOnTree(int parent[]) {
       this.tree = new ArrayList<>();
       this.pat = new ArrayList<>();
       for (int i = 0; i < parent.length; i++) {
           tree.add(new ArrayList<>());
           pat.add(new ArrayList<>());
       }
       for (int i = 0; i < parent.length; i++) {
           int a = i;
           int b = parent[i];
           tree.get(b).add(a);
           pat.get(a).add(b);
       }
   }

    public boolean lock(int num, int user) {

       if(!lock.containsKey(num)) {
           lock.put(num, user);
           return true;
       }
       return false;
    }

    public boolean unlock(int num, int user) {
         if(lock.get(num) == user) {
             lock.remove(num);
             return true;
         }
         return false;
    }

    public boolean upgrade(int num, int user) {
       if(lock.containsKey(num)) return false;
       if (!lockedAncestor(num)) return false;
       int count = lockedDescendent(num);
       if(count < 1) return false;
       lock.put(num, user);
       return true;
    }
    public boolean lockedAncestor(int start) {
       if(pat.get(start).isEmpty()) return true;
       if(lock.containsKey(start)) return false;
       return lockedAncestor(pat.get(start).getFirst());
    }
    public int lockedDescendent(int start) {

       int count = 0;
       for(int node : tree.get(start)) {
           if(lock.containsKey(node)) {
               count++;
               lock.remove(node);
           }
           lockedDescendent(node);
       }
       return count;
    }
}
