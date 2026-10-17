class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        int b1=(source[0]+source[1])%2;
        int b2=(target[0]+target[1])%2;

        if(b1!=b2)
        {
            return -1;
        }
        if(Math.abs(source[0]-target[0])==Math.abs(source[1]-target[1]))
        {
            return 1;
        }
        return 2;
    }
}