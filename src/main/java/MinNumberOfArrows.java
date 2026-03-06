import java.util.Arrays;

public class MinNumberOfArrows {

        public int findMinArrowShots(int[][] points) {

            Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

            int arrows = 1;
            int end = points[0][1];

            for (int[] point : points) {
                int start = point[0];
                int finish = point[1];

                if (start > end) {
                    arrows++;
                    end = finish;
                }
            }

            return arrows;
        }
    }

