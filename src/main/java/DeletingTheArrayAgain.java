import java.util.Scanner;

public class DeletingTheArrayAgain {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while(t-->0){
            int a=sc.nextInt();
            int arr[]=new int[a];

            int cost[]=new int[a];

            for (int i = 0; i < a; i++) {
                arr[i]=sc.nextInt();
            }
            for (int i = 0; i < a; i++) {
                cost[i]=sc.nextInt();
            }
            int idx= cost.length;

            int ans=0;
            int temp=arr.length;

            while(idx!=0) {
                int min=Integer.MAX_VALUE;

                for (int i = 0; i < temp; i++) {
                    if (cost[i] < min) {
                        min = cost[i];
                        idx = i;
                    }
                }

                for (int i = idx; i <temp ; i++) {
                   ans+=min*arr[i];
                }

                temp=idx;
            }
            System.out.println(ans);
        }
    }
}
