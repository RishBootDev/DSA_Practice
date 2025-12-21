import java.util.ArrayList;
import java.util.List;

public class DeleteColumnsToMakeSorted {

    public int minDeletionSize(String[] strs) {

        List<Integer> list=new ArrayList<>();

        for (int i = 0; i < strs[0].length(); i++) {
            StringBuilder sb=new StringBuilder();
            for (int j = 0; j < strs.length; j++) {
                sb.append(strs[j].charAt(i));
            }

            if(isSorted(sb.toString().toCharArray())){
                return list.size();
            }else{
                list.add(i);
            }
        }

        return list.size();
    }
    public boolean isSorted(char []arr){

        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i+1]<arr[i]) return false;
        }

        return true;
    }
}

