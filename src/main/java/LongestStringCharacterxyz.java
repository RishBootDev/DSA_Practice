public class LongestStringCharacterxyz {

    public int longestString(int x, int y, int z) {

        int min;
        if(x == y) return x *2 + y*2 + z*2;

        min = Math.min(x, y);

        return min*2 + (min+1) * 2 + z*2;

    }
}
