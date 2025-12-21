import java.util.List;

public class SurfaceAreaToys {

    public static int surfaceArea(List<List<Integer>> arr) {

        int H = arr.size();
        int W = arr.get(0).size();
        int area = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {

                int h = arr.get(i).get(j);
                if (h == 0) continue;

                area += 2;

                int left = (j > 0) ? arr.get(i).get(j - 1) : 0;
                area += Math.max(h - left, 0);

                int right = (j < W - 1) ? arr.get(i).get(j + 1) : 0;
                area += Math.max(h - right, 0);

                int up = (i > 0) ? arr.get(i - 1).get(j) : 0;
                area += Math.max(h - up, 0);

                int down = (i < H - 1) ? arr.get(i + 1).get(j) : 0;
                area += Math.max(h - down, 0);
            }
        }
        return area;
    }
}
