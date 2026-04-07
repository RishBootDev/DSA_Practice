import java.util.HashMap;
import java.util.Map;

public class WalkingRobotSimulation2 {

    private int x, y;
    private int width, height;
    private Map<String, String> map;
    private String currDir;
    private boolean moved;

    public WalkingRobotSimulation2(int width, int height) {

        this.x = 0;
        this.y = 0;
        this.width = width;
        this.height = height;
        this.currDir = "East";
        this.moved = false;

        map = new HashMap<>();

        // when robot reaches this corner, direction changes to:
        map.put((width - 1) + " " + 0, "North");              // bottom-right
        map.put((width - 1) + " " + (height - 1), "West");    // top-right
        map.put(0 + " " + (height - 1), "South");             // top-left
        map.put(0 + " " + 0, "East");                         // bottom-left
    }

    public void step(int num) {

        int perimeter = 2 * (width + height) - 4;
        num %= perimeter;

        if (num > 0) moved = true;

        while (num-- > 0) {

            if (this.currDir.equals("North")) {
                y++;
            } else if (this.currDir.equals("South")) {
                y--;
            } else if (this.currDir.equals("East")) {
                x++;
            } else {
                x--;
            }

            String key = x + " " + y;

            if (map.containsKey(key)) {
                currDir = map.get(key);
            }
        }

        if (x == 0 && y == 0 && moved) {
            currDir = "South";
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        return this.currDir;
    }
}