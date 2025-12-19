import java.util.ArrayList;
import java.util.Collections;

public class MedianInAStream {

    public ArrayList<Double> getMedian(int[] arr) {

        ArrayList<Double> ans=new ArrayList<>();

        ArrayList<Double> list=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            list.add((double)arr[i]);
            Collections.sort(list);
            if(i%2==0)   ans.add(list.get(i/2+1));
            else ans.add((list.get(i/2)+list.get(i/2+1))/2);
        }

        return ans;

    }
}
