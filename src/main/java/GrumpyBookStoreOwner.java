import java.util.ArrayList;
import java.util.List;

public class GrumpyBookStoreOwner {
    public static void main(String[] args) {

        int arr[]={1,0,1,2,1,1,7,5};
        int brr[]={0,1,0,1,0,1,0,1};
        System.out.println(maxSatisfied(arr,brr,3));

    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        List<Pair> pairs=new ArrayList<>();

        for (int i = 0; i <= customers.length-minutes; i++) {

            int sum=0;
            int k=minutes;
            int j=i;
            while(k-->0){

                if(grumpy[j]==0)
                   sum+=customers[j];

                j++;
            }

            Pair pair=new Pair(i,sum);
            pairs.add(pair);
        }

        pairs.sort((a, b) -> b.marks - a.marks);

        Pair pair=pairs.getFirst();
        int idx=pair.index;
        int sum=pair.marks;


        int ans=0;
        for (int i = 0; i < customers.length; i++) {

            if(i<idx && grumpy[i]==1){
                System.out.println(i);
                ans+=customers[i];
            }

            else if (i>=idx+minutes && grumpy[i]==1) {
                System.out.println(i);
                ans+=customers[i];
            }
        }

        for (int i = 0; i < minutes; i++) {
            ans+=customers[idx++];
        }


        return ans;
    }

    static class Pair{
        int index;
        int marks;

        public Pair(int index,int marks){
            this.index=index;
            this.marks=marks;
        }

        @Override
        public String toString() {
            return "index is "+this.index+" and marks are "+this.marks;
        }
    }
}
