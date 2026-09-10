public class MinimumMovesToCleanTheClassRoom {

    public int minMoves(String[] classroom, int energy) {
        char [][] arr = new char[classroom.length][classroom[0].length()];
        int i = 0;
        int count = 0;
        for(String str : classroom) {
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j);
                if(str.charAt(j) == 'L') count++;
            }
            i++;
        }

        return helper(arr, 0, 0, energy, count, new boolean[classroom.length][classroom[0].length()]);
    }

    public int helper(char[][] arr, int i, int j, int energy, int count, boolean[][] vis) {

            if(count == 0)
                return 0;
            if(energy == 0)
                return Integer.MAX_VALUE;

            vis[i][j] = true;
            int ans = Integer.MAX_VALUE;

            // UP
            if(check(arr, i - 1, j) && !vis[i - 1][j]) {

                int newEnergy = energy - 1;
                int newCount = count;

                if(arr[i - 1][j] == 'L') {
                    newCount--;
                    arr[i - 1][j] = '.';
                }

                if(arr[i - 1][j] == 'R') {
                    newEnergy = energy;
                }

                int temp = helper(arr, i - 1, j, newEnergy, newCount, vis);
                if(temp != Integer.MAX_VALUE)
                    ans = Math.min(ans, 1 + temp);
            }

            // DOWN
            if(check(arr, i + 1, j) && !vis[i + 1][j]) {

                int newEnergy = energy - 1;
                int newCount = count;

                if(arr[i + 1][j] == 'L') {
                    newCount--;
                    arr[i + 1][j] = '.';
                }
                if(arr[i + 1][j] == 'R') {
                    newEnergy = energy;
                }

                int temp = helper(arr, i + 1, j, newEnergy, newCount, vis);
                if(temp != Integer.MAX_VALUE)
                    ans = Math.min(ans, 1 + temp);
            }

            // LEFT
            if(check(arr, i, j - 1) && !vis[i][j - 1]) {

                int newEnergy = energy - 1;
                int newCount = count;

                if(arr[i][j - 1] == 'L') {
                    newCount--;
                    arr[i][j - 1] = '.';
                }

                if(arr[i][j - 1] == 'R') {
                    newEnergy = energy;
                }
                int temp = helper(arr, i, j - 1, newEnergy, newCount, vis);
                if(temp != Integer.MAX_VALUE)
                    ans = Math.min(ans, 1 + temp);
            }

            // RIGHT
            if(check(arr, i, j + 1) && !vis[i][j + 1]) {

                int newEnergy = energy - 1;
                int newCount = count;

                if(arr[i][j + 1] == 'L') {
                    newCount--;
                    arr[i][j + 1] = '.';
                }
                if(arr[i][j + 1] == 'R') {
                    newEnergy = energy;
                }

                int temp = helper(arr, i, j + 1, newEnergy, newCount, vis);
                if(temp != Integer.MAX_VALUE)
                    ans = Math.min(ans, 1 + temp);
            }
            vis[i][j] = false;
            return ans;
        }

        public boolean check(char[][] arr, int i, int j) {

            return i >= 0 && j >= 0 &&
                    i < arr.length &&
                    j < arr[0].length &&
                    arr[i][j] != 'X';
        }
}
