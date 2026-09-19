import java.util.PriorityQueue;

public class CircleAndRectangleOverlapping {

    // passed 82/90 test cases using this approach
    public boolean checkOverlap(int radius, int xCenter,
                                int yCenter, int x1,
                                int y1, int x2, int y2) {

        double dist1 = Math.sqrt(Math.pow(xCenter - x1, 2) + Math.pow(yCenter - y1, 2));
        double dist2 = Math.sqrt(Math.pow(xCenter - x2, 2) + Math.pow(yCenter - y2, 2));
        double dist3 = Math.sqrt(Math.pow(xCenter - x1, 2) + Math.pow(yCenter - y2, 2));
        double dist4 = Math.sqrt(Math.pow(xCenter - x2, 2) + Math.pow(yCenter - y1, 2));

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (p1, p2) -> Double.compare(p1.dist, p2.dist)
        );

        pq.add(new Pair(x1, y1, dist1));
        pq.add(new Pair(x2, y2, dist2));
        pq.add(new Pair(x1, y2, dist3));
        pq.add(new Pair(x2, y1, dist4));

        if(dist1 <= radius || dist2 <= radius || dist3 <= radius || dist4 <= radius) return true;
        Pair first = pq.poll();
        Pair second = pq.poll();
        int midx = (first.x + second.x)/2;
        int midy = (first.y + second.y)/2;

        double fin = Math.sqrt(Math.pow(xCenter - midx, 2) + Math.pow(yCenter - midy, 2));
        if(fin <= radius) return true;
        return false;
    }

    static class Pair{
        int x;
        int y;
        double dist;

        public Pair(int x, int y, double dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
