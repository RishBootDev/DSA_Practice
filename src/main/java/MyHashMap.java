import java.util.Arrays;

public class MyHashMap {

    int map[];

    public MyHashMap() {
        this.map = new int[10000000];
        Arrays.fill(map, -1);
    }

    public void put(int key, int value) {
        this.map[key] = value;
    }

    public int get(int key) {
        return this.map[key];
    }

    public void remove(int key) {
        this.map[key] = -1;
    }
}
