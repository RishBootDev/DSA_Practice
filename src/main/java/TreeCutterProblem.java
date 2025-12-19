public class TreeCutterProblem {

    public static int treeCutterByLinearSearch(int[] trees, int k){

       int max=Integer.MIN_VALUE;

       for(int c: trees){
           max=Math.max(c,max);
       }

        for (int i = 0; i <=max; i++) {
            int wood=0;
            for (int tree : trees) {
                if (tree >= i) {
                    wood += tree - i;
                }
            }

            if(wood==k) return i;
        }

        return -1;
    }

    public static int treeCutterByBinarySearch(int[] trees, int k){

        int max=Integer.MIN_VALUE;

        for(int c: trees){
            max=Math.max(c,max);
        }

        int i=0,j=max;

        while(i<=j){
            int mid=i+(j-i)/2;

            int wood=0;
            for (int tree : trees) {
                if (tree >= mid) {
                    wood += tree - mid;
                }
            }
            if(wood==k) return mid;
            else if(wood<k){
                j=mid-1;
            }else i=mid+1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr ={1,7,6,3,4,7};
        int[] barr={20, 15, 10, 17};
        int[] carr={4, 42, 40, 26, 46};
        System.out.println(treeCutterByLinearSearch(arr,8));
        System.out.println(treeCutterByBinarySearch(arr,8));
        System.out.println(treeCutterByBinarySearch(barr,7));
        System.out.println(treeCutterByBinarySearch(carr,20));
    }
}
