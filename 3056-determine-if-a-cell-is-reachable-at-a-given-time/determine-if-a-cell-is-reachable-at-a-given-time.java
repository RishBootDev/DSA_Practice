class Solution {

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        return helper(sx, sy, fx, fy, t);
    }

    public boolean helper(int x, int y, int fx, int fy, int t) {

        if(t == 0) {
            return x == fx && y == fy;
        }
        int distance = Math.max(Math.abs(fx - x), Math.abs(fy - y));
        if(distance > t) {
            return false;
        }
        if(x == fx && y == fy && t == 1) {
            return false;
        }
        return true;
    }
}