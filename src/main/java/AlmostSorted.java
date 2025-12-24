import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlmostSorted {

    public static void almostSorted(List<Integer> arr) {

        List<Integer> list = new ArrayList<>(arr);

        Collections.sort(list);
        int count=0;
        List<Integer> temp=new ArrayList<>();

        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i)!=arr.get(i)){
                temp.add(i);
            }
        }
        if(temp.isEmpty()) System.out.println("Yes");

        else if(temp.size()==2){
            int a=arr.get(temp.get(0));
            int b=arr.get(temp.get(1));
            arr.set(temp.get(0),b);
            arr.set(temp.get(1),a);

            if(checkSorted(arr)){
                System.out.println("Yes");
                System.out.println("swap "+a+" "+b);
            }else System.out.println("No");
        }

        else {
            int i=temp.get(0);
            int j=temp.getLast();

            while(i<j){
                int a=arr.get(i);
                int b=arr.get(j);

                arr.set(i,b);
                arr.set(j,a);
            }

            if(checkSorted(arr)){
                System.out.println("Yes");
            }else System.out.println("No");
        }

    }
    public static boolean checkSorted(List<Integer> list){
        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i+1)<list.get(i)) return false;
        }

        return true;
    }
}
