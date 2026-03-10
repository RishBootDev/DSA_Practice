import java.util.HashMap;

public class CheckIFAllLevelsOfTreesAreAnagrams {

    public static int level(Node root)
    {
        if(root==null) return 0;
        return 1+(int)Math.max(level(root.left),level(root.right));
    }
    public static void levelOrder(Node root, HashMap<Integer,Integer> map, int i, int j)
    {
        // if(j>i) return;
        if(root==null) return ;
        if(i==j)
        {
            if(!map.containsKey(root.data)) map.put(root.data,1);
            else map.put(root.data,map.get(root.data)+1);
            return;
        }
        levelOrder(root.left,map,i,j+1);
        levelOrder(root.right,map,i,j+1);

    }
    public static void levelOrder2(Node root, HashMap<Integer,Integer> map,int i,int j,boolean [] arr)
    {
        // if(j>i) return;
        if(root==null) return ;
        if(i==j)
        {
            if(!map.containsKey(root.data))
            {
                arr[0]=false;
            }
            if(map.containsKey(root.data))
            {
                map.put(root.data,map.get(root.data)-1);
                if(map.get(root.data)==0) map.remove(root.data);
            }

        }
        levelOrder2(root.left,map,i,j+1,arr);
        levelOrder2(root.right,map,i,j+1,arr);

    }
    public static boolean areAnagrams(Node node1, Node node2) {
        int level1=level(node1);
        int level2=level(node2);
        if(level1!=level2) return false;
        for(int i=0;i<level1;i++)
        {
            HashMap<Integer,Integer> map=new HashMap<>();
            levelOrder(node1,map,i,0);
            boolean[] arr={true};
            levelOrder2(node2,map,i,0,arr);
            if(arr[0]==false) return false;

        }
        return true;
    }

    static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
