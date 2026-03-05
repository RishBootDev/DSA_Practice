import java.util.Arrays;

public class MaximumNumberOfGroups {

    public int maximumGroups(int[] grades) {

        Arrays.sort(grades);

        int k = 1;
        int count = 0;
        for (int i = 0; i < grades.length;) {
            int sum = 0;
            int temp = k++;
            while(temp -- > 0) {
                if(i == grades.length) return count;
                sum += grades[i];
                System.out.print(grades[i]+" ");
                i++;
            }
            count++;
            System.out.println();

        }

        return count;
    }
}
