import java.util.Arrays;

public class SortTheStudentsBykthScore {

    public int[][] sortTheStudents(int[][] score, int k) {

        Arrays.sort(score,(a,b)->a[k]-b[k]);
        return score;
    }
}
