import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FormTheLargestNumber {

    public String findLargest(int []arr){

        List<Integer> list=new ArrayList<>();
        for(int x: arr) list.add(x);

        Collections.sort(list, (a, b) -> {
            String ab = a + "" + b;
            String ba = b + "" + a;
            return ba.compareTo(ab);
        });

        StringBuilder sb=new StringBuilder();

        for(int c: list) sb.append(c);

        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println("3".compareTo("30"));
    }
}
