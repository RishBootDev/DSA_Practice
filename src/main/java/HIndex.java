import java.util.*;

public class HIndex {

    // This is HI index 1
    public int hIndex(int[] arr) {

        List<Integer> list = new ArrayList<>();
        for (int x : arr) list.add(x);

        list.sort(Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            if (list.get(i) < i + 1) return i;
        }

        return arr.length;
    }

    // This is HI index 2
    public int hIndex2(int[] citations) {
        int j = 0;

        for(int i = citations.length -1; i >=0 ;i--) {
            if(citations[i] < j + 1) return j;

            j++;
        }

        return citations.length;
    }

    // this is the binary search version of the hi index
    public int hIndex3(int[] citations) {

        int left = 0, right = citations.length - 1;
        int ans = 0;
        int n = citations.length;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            int papers = n - mid;

            if (citations[mid] >= papers) {
                ans = papers;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
