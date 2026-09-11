import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MyHashSet {

    List<Integer> set;
    public MyHashSet() {
        this.set = new ArrayList<>();
    }

    public void add(int key) {
        this.set.add(key);
    }

    public void remove(int key) {
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()) {
            if(iterator.next().equals(key)) {
                iterator.remove();
            }
        }
    }

    public boolean contains(int key) {
        for(int c : set) {
            if(c == key) return true;
        }
        return false;
    }
}
