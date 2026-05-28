class Solution {

    public int videoStitching(int[][] clips, int time) {

        Arrays.sort(clips, (a, b) -> a[0] - b[0]);

        int count = 0;
        int currEnd = 0;
        int farthest = 0;

        for (int i = 0; i < clips.length; i++) {

            if (clips[i][0] > farthest) {
                return -1;
            }

            if (clips[i][0] > currEnd) {
                count++;
                currEnd = farthest;
            }

            farthest = Math.max(farthest, clips[i][1]);

            if (farthest >= time) {
                return count + 1;
            }
        }

        return -1;
    }
}