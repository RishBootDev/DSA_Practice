public class KeysKeyboardA {

        public int minSteps(int n) {
            if(n == 1) return 0;

            return 1 + helper(n, 1, 1);
        }

        public int helper(int n, int curr, int clipboard) {

            if(curr == n) {
                return 0;
            }

            if(curr > n) {
                return 100000;
            }
            // paste
            int paste = 1 + helper(n, curr + clipboard, clipboard);
            // copy + paste
            int copyPaste = 2 + helper(n, curr * 2, curr);
            return Math.min(paste, copyPaste);
        }

}
