class LUPrefix {

    boolean[] vid;
    int longest = 0;

    public LUPrefix(int n) {
        vid = new boolean[n + 1];
    }

    public void upload(int video) {
        vid[video] = true;

        while (longest + 1 < vid.length &&
               vid[longest + 1]) {
            longest++;
        }
    }

    public int longest() {
        return longest;
    }
}