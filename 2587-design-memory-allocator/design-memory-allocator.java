class Allocator {

    int mem [];
        public Allocator(int n) {
             mem = new int[n];
        }

        public int allocate(int size, int mID) {
            int idx = getIndex(size);
            if(idx == -1) return -1;
            for (int i = idx; i < (idx + size) ; i++) {
                mem[i] = mID;
            }
            return idx;
        }

        public int freeMemory(int mID) {
            int count = 0;
            for (int i = 0; i < mem.length; i++) {
                if(mem[i] == mID) {
                    mem[i] = 0;
                    count++;
                }
            }
            return count;
        }
        public int getIndex(int size) {

            int count = 0;
            for (int i = 0; i < mem.length; i++) {
                if (mem[i] == 0) {
                    count++;
                    if (count == size) {
                        return i - size + 1;
                    }
                } else {
                    count = 0;
                }
            }
            return -1;
        }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.freeMemory(mID);
 */