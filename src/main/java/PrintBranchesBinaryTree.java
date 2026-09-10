import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintBranchesBinaryTree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0) {
            int a = sc.nextInt();

            int arr[] = new int[a];
            List<List<Integer>> tree = new ArrayList<>();

            for (int i = 0; i < a; i++) {
                tree.add(new ArrayList<>());
                arr[i] = sc.nextInt();
            }

            while(a-->1) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                tree.get(u - 1).add(v - 1);
            }

            System.out.println(printPath(tree, arr, 0, 0));
        }
    }

    public static long printPath(List<List<Integer>> tree, int arr[], int i, long num) {

        long mod = 1000000007;

        num = (num * 10 + arr[i]) % mod;

        if(tree.get(i).isEmpty()) {
            return num;
        }

        long sum = 0;

        if(tree.get(i).size() == 2) {
            sum = (sum + printPath(tree, arr, tree.get(i).getFirst(), num)) % mod;
            sum = (sum + printPath(tree, arr, tree.get(i).getLast(), num)) % mod;
        } else {
            sum = (sum + printPath(tree, arr, tree.get(i).getFirst(), num)) % mod;
        }

        return sum;
    }

}
