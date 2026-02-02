import java.util.ArrayList;
import java.util.List;

public class GroupThePeople {

    public List<List<Integer>> groupThePeople(int[] arr) {

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            List<Integer> temp = list.get(i);
            temp.add(i);
        }

        return list;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            System.out.println(Integer.toBinaryString(i));
        }
    }


}
