class Solution {

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        return helper(sx, sy, tx, ty);
    }

    public boolean helper(int sx, int sy, int tx, int ty) {

        if(tx < sx || ty < sy) {
            return false;
        }
        if(tx == sx && ty == sy) {
            return true;
        }
        if(tx == sx) {
            return (ty - sy) % sx == 0;
        }
        if(ty == sy) {
            return (tx - sx) % sy == 0;
        }
        if(tx > ty) {
            return helper(sx, sy, tx % ty, ty);
        }
        return helper(sx, sy, tx, ty % tx);
    }
}